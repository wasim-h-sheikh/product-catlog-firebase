package com.qstest.presentation.di.core

import com.qstest.data.api.APIService
import com.qstest.data.repository.datasource.ProductsRemoteDatasource
import com.qstest.data.repository.datasourceImpl.ProductsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideProductsRemoteDatasource(apiService: APIService): ProductsRemoteDatasource {
        return ProductsRemoteDataSourceImpl(
            apiService
        )
    }

}