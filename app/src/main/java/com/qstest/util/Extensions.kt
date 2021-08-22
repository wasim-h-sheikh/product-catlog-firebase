package com.qstest.util

import com.qstest.data.model.Product

fun List<String>.toProducts():List<Product>{
    val productList=ArrayList<Product>()
    forEach { id->
        productList.add(Product(id))
    }
    return productList
}