package com.example.myshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshop.model.Products
import com.example.myshop.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel :ViewModel(){
    val productsRepo = ProductRepository()
    var productsLiveData = MutableLiveData<List<Products>>()
    var errorLiveData= MutableLiveData<String>()

    fun fetchProducts() {
        viewModelScope.launch {
            val response = productsRepo.getProducts()
            if (response.isSuccessful) {
                productsLiveData.postValue(response.body()?.products)
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }

        }
    }


}