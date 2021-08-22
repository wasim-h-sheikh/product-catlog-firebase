package com.qstest.presentation.di

import com.qstest.presentation.di.product.ProductSubComponent


interface Injector {
    fun createProductSubComponent(): ProductSubComponent
}