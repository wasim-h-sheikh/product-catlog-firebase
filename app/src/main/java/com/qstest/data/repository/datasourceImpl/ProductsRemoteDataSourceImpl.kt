package com.qstest.data.repository.datasourceImpl

import com.qstest.data.api.APIService
import com.qstest.data.repository.datasource.ProductsRemoteDatasource
import retrofit2.Response

class ProductsRemoteDataSourceImpl(
    private val apiService: APIService
): ProductsRemoteDatasource {
    override suspend fun getProductIds(): Response<List<String>> =apiService.getProductIds()
}

