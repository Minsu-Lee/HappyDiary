package com.hackathon.happydiary.base

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.happydiary.R
import com.hackathon.happydiary.view.component.NetworkProgressDialog
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoComponent
import org.koin.android.ext.android.inject
import java.util.*
import java.util.concurrent.TimeUnit

abstract class BaseActivity<VIEW: BaseView, P: AbstractPresenter<VIEW>>: AppCompatActivity(), BaseView {

    companion object {
        const val DEFAULT_PROGRESS_TIME: Long = 1000L
    }

    val pref: PreferencesManager by inject()
    lateinit var mProgressView: AlertDialog
    lateinit var backPressHandler: BackPressCloseHandler

    abstract var layout: AnkoComponent<Activity>
    protected var presenter: P? = null
    abstract fun onCreatePresenter(): P?

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.act_slide_right_in, R.anim.stay)
        super.onCreate(savedInstanceState)
        // TimeZone Asia/Seoul로 지정
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
        presenter = onCreatePresenter()?.apply {
            this.ctx = this@BaseActivity
        }
        presenter?.attachView(this as VIEW)
        with(layout) {
            setContentView(createView(org.jetbrains.anko.AnkoContext.create(this@BaseActivity, this@BaseActivity)))
        }

        mProgressView = NetworkProgressDialog.getInstance(this@BaseActivity)
        backPressHandler = BackPressCloseHandler(this@BaseActivity)
    }

    override fun onVisibleProgress() {
        mProgressView.show()
    }

    override fun onInvisibleProgress() {
        mProgressView.let {
            if (it.isShowing) Handler().postDelayed({
                it.dismiss()
            }, DEFAULT_PROGRESS_TIME)
        }
    }

    override fun movePage(callback: (Long)->Unit, delay: Long, timeUnit: TimeUnit) {
        Observable.timer(delay, timeUnit)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(callback)
    }

}