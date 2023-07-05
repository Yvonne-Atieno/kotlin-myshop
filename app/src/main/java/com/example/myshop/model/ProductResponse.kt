package com.example.myshop.model

import com.example.myshop.model.Products

class ProductsResponse (
    var products: List<Products>,
    var total:Int,
    var skip:Int,
    var  limit:Int,
)