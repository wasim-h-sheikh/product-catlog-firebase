package com.qstest.presentation.di.core

import com.qstest.domain.repository.ProductRepository
import com.qstest.domain.usecase.GetProductIdsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetProductIdsUseCase(productRepository: ProductRepository): GetProductIdsUseCase {
        return GetProductIdsUseCase(productRepository )
    }

}