package com.example.myshop
import com.example.myshop.model.Products
import com.example.myshop.model.ProductsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/products")
    suspend fun getProducts():Response<ProductsResponse>

    @GET("/products/{id}")
    suspend fun getProducts(@Path("id") productId:Int):Response<Products>


}