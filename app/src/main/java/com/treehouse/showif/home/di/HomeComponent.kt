package com.treehouse.showif.home.di

import com.treehouse.showif.home.MainActivity
import com.treehouse.showif.retrofit.AppComponent

import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun inject(mainActivity: MainActivity)
}