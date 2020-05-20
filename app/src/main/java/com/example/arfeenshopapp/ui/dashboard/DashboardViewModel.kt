package com.example.arfeenshopapp.ui.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import models.Product
import shopify.api.ShopifyApiRepository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DashboardViewModel(application: Application) : AndroidViewModel(application) {
    private val shopifyApiRepository = ShopifyApiRepository()
    val product = MutableLiveData<Product>()
    val category = MutableLiveData<Product>()
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