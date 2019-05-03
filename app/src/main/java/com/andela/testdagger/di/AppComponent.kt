package com.andela.testdagger.di

import com.andela.testdagger.MainActivity
import com.andela.testdagger.di.module.AppModule
import com.andela.testdagger.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    NetworkModule::class,
    AppModule::class])
interface AppComponent {

    fun inject(application: MainActivity)

}