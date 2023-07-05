package com.example.myshop.model

data class Products(
    var id:Int,
    var tittle:String,
    var description:String,
    var price:Double,
    var brand:String,
    var category: String,
    var thumbnail:String,
    var stock:Int,
    var ratings:Double,

)
