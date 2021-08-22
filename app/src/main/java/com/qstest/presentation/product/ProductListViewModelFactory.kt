package com.qstest.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.qstest.domain.usecase.GetProductIdsUseCase

class ProductListViewModelFactory(
    private val getProductIdsUseCase: GetProductIdsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductListViewModel(
            getProductIdsUseCase
        ) as T
    }
}