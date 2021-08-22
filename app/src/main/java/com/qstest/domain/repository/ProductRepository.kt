package com.qstest.domain.repository


interface ProductRepository {
    suspend fun getProductIds():List<String>?
}