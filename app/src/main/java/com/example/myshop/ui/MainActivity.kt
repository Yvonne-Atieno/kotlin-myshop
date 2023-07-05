package com.example.myshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.ApiInterface
import com.example.myshop.model.ProductsResponse
import com.example.myshop.api.ApiClient
import com.example.myshop.databinding.ActivityMainBinding
import com.example.myshop.viewmodel.ProductViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val productsViewModel:ProductViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
         productsViewModel   .fetchProducts()
        productsViewModel.productsLiveData
            .observe(this, Observer { productsList->
        Toast
            .makeText(baseContext,"fetched ${productsList?.size} products",Toast.LENGTH_LONG)
            .show()
                binding.rvProducts.layoutManager=LinearLayoutManager(this)
                binding.rvProducts.adapter=ProductsRvAdapter(productsList)

    })

        productsViewModel.errorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
    }