package com.qstest.data.model

data class Product(
    var id:String,
    var name: String?,
    var price:String?,
    var desc: String?,
    var image: String?
){
    constructor(id: String): this(id,null,null,null,null)
}