package com.qstest.presentation.product

import androidx.lifecycle.*
import com.qstest.domain.usecase.GetProductIdsUseCase

class ProductListViewModel(
    private val getProductIdsUseCase: GetProductIdsUseCase
): ViewModel() {
    fun getProductsIds() = liveData {
        val idsList = getProductIdsUseCase.execute()
        emit(idsList)
    }

}