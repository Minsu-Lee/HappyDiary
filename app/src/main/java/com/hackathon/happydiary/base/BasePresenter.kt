package com.hackathon.happydiary.base

import io.reactivex.disposables.CompositeDisposable

interface BasePresenter<in VIEW : BaseView> {

    var mCompositeDisposable: CompositeDisposable
    /**
     * View Attach.
     */
    fun attachView(view: VIEW)

    /**
     * View detach
     */
    fun detachView()

    fun handleError(error: Throwable)

}