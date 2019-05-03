package com.andela.testdagger.application

import android.app.Application
import com.andela.testdagger.di.AppComponent
import com.andela.testdagger.di.module.AppModule
import com.andela.testdagger.di.DaggerAppComponent
import com.andela.testdagger.di.module.NetworkModule
import com.facebook.stetho.Stetho

class RootApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initDagger(this)
        Stetho.initializeWithDefaults(this)
    }

    private fun initDagger(app: Application): AppComponent {
        appComponent = DaggerAppComponent.builder()
                .networkModule(NetworkModule)
                .appModule(AppModule(app))
                .build()
        return appComponent
    }
}