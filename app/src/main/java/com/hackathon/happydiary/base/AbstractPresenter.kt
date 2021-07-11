package com.hackathon.happydiary.base

import android.content.Context
import android.widget.Toast
import com.hackathon.happydiary.utils.DLog
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class AbstractPresenter<VIEW : BaseView>() : BasePresenter<VIEW> {

    companion object {
        const val MENU_ITEM_TYPE = "cart"
    }

    override var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    lateinit var ctx: Context
    protected var view: VIEW? = null

    override fun attachView(view: VIEW) {
        this.view = view
    }

    override fun detachView() {
        view = null
        clearDisposable()
    }

    override fun handleError(error: Throwable) {
        view?.onInvisibleProgress()
        DLog.e("handleError", "error : ${error.message}")
    }

    fun addDisposable(disposable: Disposable?) {
        disposable?.let { mCompositeDisposable.add(it) }
    }

    fun removeDisposable(disposable: Disposable?) {
        disposable?.let { mCompositeDisposable.dispose() }
    }

    fun clearDisposable() = mCompositeDisposable.let { if (it.size() > 0) it.clear() }

    fun moveLoginPage() {

    }

    fun toast(msg: String): Toast = Toast.makeText(ctx, msg, Toast.LENGTH_LONG).also { it.show() }
    fun log(tag: String, msg: String) {
        DLog.e(tag, msg)
        toast(msg)
    }
    fun log(Class: Class<*>, msg: String) = log(Class.simpleName, msg)

}