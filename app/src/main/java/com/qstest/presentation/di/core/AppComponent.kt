package com.qstest.presentation.di.core

import com.qstest.presentation.di.product.ProductSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class
    ]
)
interface AppComponent {
    fun productSubComponent(): ProductSubComponent.Factory
}