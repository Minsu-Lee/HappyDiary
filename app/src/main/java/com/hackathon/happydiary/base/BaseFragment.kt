package com.hackathon.happydiary.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.hackathon.happydiary.view.component.NetworkProgressDialog
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.UI
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.textView
import org.koin.android.ext.android.inject
import java.util.*
import java.util.concurrent.TimeUnit

abstract class BaseFragment<VIEW: BaseView, P: AbstractPresenter<VIEW>>: Fragment(), BaseView {

    companion object {
        const val DEFAULT_PROGRESS_TIME: Long = 1000L
    }

    val pref: PreferencesManager by inject()
    lateinit var mProgressView: AlertDialog

    abstract var layout: AnkoComponent<Context>
    protected var presenter: P? = null
    abstract fun onCreatePresenter(): P?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TimeZone Asia/Seoul로 지정
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
        presenter = onCreatePresenter()?.apply {
            context?.let { this.ctx = it }
            attachView(this@BaseFragment as VIEW)
        }
        mProgressView = NetworkProgressDialog.getInstance(ctx)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return with(layout) {
            createView(org.jetbrains.anko.AnkoContext.create(requireActivity(), false))
        }
    }

    override fun onVisibleProgress() = mProgressView.show()
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