package com.treehouse.showif.retrofit

import com.treehouse.showif.network.PhotoServices
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {
    fun PhotoServices(): PhotoServices
}