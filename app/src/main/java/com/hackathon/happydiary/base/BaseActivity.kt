package com.hackathon.happydiary.base

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.happydiary.R
import com.hackathon.happydiary.view.component.NetworkProgressDialog
import org.jetbrains.anko.AnkoComponent
import java.util.*

abstract class BaseActivity<VIEW: BaseView, P: BasePresenter<VIEW>>: AppCompatActivity(), BaseView {

    companion object {
        const val DEFAULT_PROGRESS_TIME: Long = 1000L
    }

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
        presenter = onCreatePresenter()
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

}