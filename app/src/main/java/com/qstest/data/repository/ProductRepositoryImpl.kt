package com.qstest.data.repository

import android.util.Log
import com.qstest.data.repository.datasource.ProductsRemoteDatasource
import com.qstest.domain.repository.ProductRepository
import java.lang.Exception

class ProductRepositoryImpl(
    private val productsRemoteDatasource: ProductsRemoteDatasource
) : ProductRepository {

    override suspend fun getProductIds(): List<String>? {
       return getProductIdsFromAPI()
    }


    private suspend fun getProductIdsFromAPI(): List<String> {
        lateinit var idsList: List<String>
        try {
            val response = productsRemoteDatasource.getProductIds()
            val body = response.body()
            if(body!=null){
                idsList = body
            }
        } catch (exception: Exception) {
            Log.v("ProductRepositoryImpl", exception.message.toString())
        }
        return idsList
    }
}