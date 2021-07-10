package com.hackathon.happydiary.base

import com.hackathon.happydiary.utils.DLog
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class AbstractPresenter<VIEW : BaseView>() : BasePresenter<VIEW> {

    companion object {
        const val MENU_ITEM_TYPE = "cart"
    }

    override var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

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
        DLog.e("handleError", "error : ${error.printStackTrace()}")
    }

    fun addDisposable(disposable: Disposable?) {
        disposable?.let { mCompositeDisposable.add(it) }
    }

    fun removeDisposable(disposable: Disposable?) {
        disposable?.let { mCompositeDisposable.dispose() }
    }

    fun clearDisposable() = mCompositeDisposable.let { if (it.size() > 0) it.clear() }

}