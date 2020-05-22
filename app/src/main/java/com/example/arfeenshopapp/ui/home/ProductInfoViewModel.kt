package com.example.arfeenshopapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import models.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shopify.api.ShopifyApiRepository

class ProductInfoViewModel : ViewModel() {

    private val shopifyApiRepository = ShopifyApiRepository()
    val product = MutableLiveData<Product>()
    val error = MutableLiveData<String>()


    fun getProducts() {
        shopifyApiRepository.getProducts().enqueue((object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {
                    product.value = response.body()
                } else {
                    error.value = "Error ${response.errorBody().toString()}"
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                error.value = t.message

            }

        }))
    }
}