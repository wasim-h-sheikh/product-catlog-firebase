package com.qstest.data.api

import retrofit2.Response
import retrofit2.http.GET


interface APIService {

    @GET("product-ids")
    suspend fun getProductIds(): Response<List<String>>

}