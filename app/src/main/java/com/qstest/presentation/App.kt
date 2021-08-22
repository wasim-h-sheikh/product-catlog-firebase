package com.qstest.presentation

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.qstest.BuildConfig
import com.qstest.presentation.di.Injector
import com.qstest.presentation.di.core.*
import com.qstest.presentation.di.product.ProductSubComponent

class App : MultiDexApplication(), Injector {
    private lateinit var appComponent: AppComponent

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()

    }


    override fun createProductSubComponent(): ProductSubComponent {
        return appComponent.productSubComponent().create()
    }


}