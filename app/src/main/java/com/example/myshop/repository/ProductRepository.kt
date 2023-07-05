package com.example.myshop.repository


import com.example.myshop.ApiInterface
import com.example.myshop.api.ApiClient
import com.example.myshop.model.ProductsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
class ProductRepository {
    val apiClient=
        ApiClient.buildClient(ApiInterface::class.java)

        suspend fun getProducts():Response<ProductsResponse>{
             return withContext(Dispatchers.IO){
                 apiClient.getProducts()
    }
}
}