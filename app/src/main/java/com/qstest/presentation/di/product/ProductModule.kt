package com.qstest.presentation.di.product

import com.qstest.domain.usecase.GetProductIdsUseCase
import com.qstest.presentation.product.ProductListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ProductModule {
    @ProductScope
    @Provides
    fun provideProductListViewModelFactory(
        getProductIdsUseCase: GetProductIdsUseCase
    ): ProductListViewModelFactory {
        return ProductListViewModelFactory(
            getProductIdsUseCase
        )
    }

}