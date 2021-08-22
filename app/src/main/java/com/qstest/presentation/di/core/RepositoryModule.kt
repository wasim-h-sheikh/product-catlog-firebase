package com.qstest.presentation.di.core


import com.qstest.data.repository.ProductRepositoryImpl
import com.qstest.data.repository.datasource.ProductsRemoteDatasource
import com.qstest.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(
        productsRemoteDatasource: ProductsRemoteDatasource
    ): ProductRepository {

        return ProductRepositoryImpl(
            productsRemoteDatasource
        )
    }

}