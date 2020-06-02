package com.example.arfeenshopapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arfeenshopapp.ui.notifications.NotificationsViewModel
import models.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shopify.api.ShopifyApiRepository

class ProductInfoViewModel : ViewModel() {

    private val shopifyApiRepository = ShopifyApiRepository()
    val product = MutableLiveData<Product>()
    val error = MutableLiveData<String>()


    fun getProduct(product_id: Long) {
        shopifyApiRepository.getProducten(product_id).enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {
                    product.value = response.body()
                } else {
                    error.value = "An error occurred: ${response.errorBody().toString()}"
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                error.value = t.message
                Log.e("error", error.value)
            }
        })
    }

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