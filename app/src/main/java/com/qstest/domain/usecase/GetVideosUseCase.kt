package com.qstest.domain.usecase

import com.qstest.domain.repository.ProductRepository

class GetProductIdsUseCase(private val productRepository: ProductRepository) {
    suspend fun execute():List<String>? = productRepository.getProductIds()

}