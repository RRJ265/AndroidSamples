package com.example.daggercoroutines

import android.app.Application
import com.example.daggercoroutines.di.AppComponent
import com.example.daggercoroutines.di.DaggerAppComponent

class MyApplication : Application() {

lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}