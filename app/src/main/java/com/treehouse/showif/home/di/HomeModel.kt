package com.treehouse.showif.home.di

import com.treehouse.showif.network.PhotoServices
import com.treehouse.showif.home.HomeContract
import com.treehouse.showif.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val view: HomeContract.View) {

    @HomeScope
    @Provides
    fun provideHomePresenter(PhotoServices: PhotoServices)
            : HomeContract.Presenter {
        return HomePresenter(PhotoServices, view)
    }
}