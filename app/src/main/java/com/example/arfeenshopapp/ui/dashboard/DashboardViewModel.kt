package com.example.arfeenshopapp.ui.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import models.Collections
import models.Product
import shopify.api.ShopifyApiRepository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DashboardViewModel(application: Application) : AndroidViewModel(application) {
    private val shopifyApiRepository = ShopifyApiRepository()
    val product = MutableLiveData<Product>()
    val category= MutableLiveData<Collections>()
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

    //het zelfde voor de collection aka category
    fun getCategory(){
        shopifyApiRepository.getCollections().enqueue((object : Callback<Collections> {
            override fun onResponse(call: Call<Collections>, response: Response<Collections>) {
                if (response.isSuccessful) {
                    category.value = response.body()
                } else {
                    error.value = "Error ${response.errorBody().toString()}"
                }
            }

            override fun onFailure(call: Call<Collections>, t: Throwable) {
                error.value = t.message

            }

        }))
    }

}