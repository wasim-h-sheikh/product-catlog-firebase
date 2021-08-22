package com.qstest.data.repository.datasource

import retrofit2.Response

interface ProductsRemoteDatasource {
   suspend fun getProductIds(): Response<List<String>>
}