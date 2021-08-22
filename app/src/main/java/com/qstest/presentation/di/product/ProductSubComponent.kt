package com.qstest.presentation.di.product

import com.qstest.presentation.product.ProductListFragment
import dagger.Subcomponent

@ProductScope
@Subcomponent(modules = [ProductModule::class])
interface ProductSubComponent {
    fun inject(productListFragment: ProductListFragment)
    @Subcomponent.Factory
    interface Factory {
        fun create(): ProductSubComponent
    }

}

