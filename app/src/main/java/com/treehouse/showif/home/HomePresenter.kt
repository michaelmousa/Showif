package com.treehouse.showif.home

import com.treehouse.showif.network.PhotoServices
import java.net.SocketException
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter  (

    private val photoServices: PhotoServices,
    private val view: HomeContract.View): HomeContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getPhotoDetails(users:String) {

        compositeDisposable.add(photoServices.getPhotoDetails(users)
            .subscribeOn(Schedulers.io())
            .map { it }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ view.showResults(it) },

                { failure ->
                    if (failure is SocketException) {
                        view.showError("Error")
                    } else {
                        view.showError(failure?.message ?: "An unknown error happened")
                    }}))}}



