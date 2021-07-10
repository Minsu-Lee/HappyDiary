package com.hackathon.happydiary.extensions

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.hackathon.happydiary.utils.DLog
import com.hackathon.happydiary.utils.DeviceUtils
import com.hackathon.happydiary.utils.SSLHelper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.onStart
import okhttp3.OkHttpClient.Builder
import retrofit2.Retrofit
import java.text.SimpleDateFormat
import java.util.*


inline fun Builder.applySSL(): Builder = SSLHelper.configureClient(this)

fun <T> Single<T>.with(): Single<T> = subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

inline fun <T> Retrofit.init(service: Class<T>) = create(service)

fun <T> MutableLiveData<T>.get(): T? {
    return this.value
}
fun <T> MutableLiveData<T>.getDefault(default: T): T = when {
    (value != null) || (value != null && value == "" && default == "") -> value!!
    else -> default
}
fun <T> MutableLiveData<T>.set(value: T) : MutableLiveData<T> {
    this.value = value
    return this
}
// 참조 : https://blog.codejun.space/86
fun <T> MutableLiveData<T>.setPost(value: T) : MutableLiveData<T> {
    this.setPost(value)
    return this
}

/**
 * 단일 클릭 on / off
 * API 응답이 오기전 여러차례 요청을 보내는 이슈 대안
 */
fun View.safeViewLock(lock: Boolean) {
    isEnabled = !lock
    isClickable = !lock
}

/**
 * 참고 : https://meetup.toast.com/posts/130
 * formatStr : datetime의 format
 * timeZone : 변경하려는 TimeZone
 */
fun String.toDate(formatStr: String = "yyyy-MM-dd'T'HH:mm:ss'Z'", timeZone: TimeZone = TimeZone.getTimeZone("Asia/seoul")): Date {
    return with(SimpleDateFormat(formatStr).also { it.timeZone = timeZone }) {
        parse(this@toDate)
    }
}
fun Date.dateFormat(toFormatStr: String, locale: Locale = Locale.KOREAN) = with(SimpleDateFormat(toFormatStr, locale)) {
    this.format(this@dateFormat)
}


// https://youtu.be/7m5T10OYGUA
@ExperimentalCoroutinesApi
fun EditText.textChangesToFlow(): Flow<CharSequence?> {

    // flow 콜백 받기
    return callbackFlow<CharSequence?> {

        val listener = object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun afterTextChanged(p0: Editable?) = Unit
            override fun onTextChanged(txt: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // 값 내보내기
                offer(txt)
            }
        }

        // 리스너 등록
        addTextChangedListener(listener)

        // 콜백이 사라질때 실행됨, callbackFlow가 종료되는 시점
        awaitClose {
            removeTextChangedListener(listener)
        }
    }.onStart {
        // Rx 에서 onNext와 동일
        // emit으로 이벤트 전달달
        emit(text)
    }
}

/**
 * CoroutineContext thread pool에 job을 할당
 * private var myCoroutineJob: Job = Job()
 * private val myCoroutineContext: CoroutineContext
 *     get() = Dispatchers.IO + myCoroutineJob  // 할당하는 부분
 *
 * onDestroyed에서     myCoroutineContext.cancel() 호출로 clear 함
 *
 * // 아래와 같이 별도 Scope을 생성하는 경우 Thread 풀과 Job을 할당하여 지정할 수 있음.
 * // GlobalScope.launch(context= Dispatchers.IO)
 *
 * GlobalScope.launch(myCoroutineContext) {
 *     editText.textChangesToFlow()
 *         .debounce(2000)
 *         .filter {
 *             it?.length ?: 0 > 0
 *         }
 *         .onEach {
 *             Log.d(TAG, "flow로부터 전달받음, $it")
 *         }
 *         .launchIn(this)  // GlobalScope에서 동작되야함을 알려줌, this는 GlobalScope
 * }
 */

/**
 * 양방향 데이터바인딩을 위해 아래와 같이 LiveData를 사용
 */
inline fun EditText.setLiveData(lifecycleOwner: LifecycleOwner?, liveData: MutableLiveData<String>?, crossinline changed: (String)->Unit? = {}) {
    // 변동된 값을 LiveData에도 반영
    addTextChangedListener(object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }
        override fun afterTextChanged(s: Editable?) {
            changed(this@setLiveData.text.toString())
            liveData?.let { data ->
                val currentText = this@setLiveData.text.toString()
                if (data.value != currentText) {
                    data.value = currentText
                    DLog.e("editText", "change: ${this@setLiveData.text}")
                }
            }
        }
    })
    // 외부에서 liveData 값을 변경할 수 있으므로, 구독하여 데이터 변동 체크
    lifecycleOwner?.let { owner ->
        liveData?.observe(owner) {
            val currentText = this@setLiveData.text.toString()
            if (it != currentText) {
                setText(it)
                DLog.e("observe", "change: ${this@setLiveData.text}")
            }
        }
    } ?: setText(liveData?.getDefault(""))
}

/**
 * liveData로 키보드 노출여부를 제어하기 위해 사용
 */
inline fun EditText.initKeyboardControl(lifecycleOwner: LifecycleOwner?, liveData: MutableLiveData<Boolean>?) {
    lifecycleOwner?.let { owner ->
        liveData?.observe(owner, Observer {
            if (it) DeviceUtils.showKeyboard(context, this) else DeviceUtils.hideKeyboard(context, this)
        })
    }
}