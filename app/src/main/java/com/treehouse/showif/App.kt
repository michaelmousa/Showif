package com.treehouse.showif

import android.app.Application
import com.treehouse.showif.retrofit.AppComponent
import com.treehouse.showif.retrofit.DaggerAppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build();
    }
    fun getComponent() = appComponent
}