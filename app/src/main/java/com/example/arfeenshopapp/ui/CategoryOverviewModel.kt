package com.example.arfeenshopapp.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import models.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shopify.api.ShopifyApiRepository

class CategoryOverviewModel(application: Application) : AndroidViewModel(application) {
    private val shopifyApiRepository = ShopifyApiRepository()
    val collectionProduct = MutableLiveData<Product>()
    val error = MutableLiveData<String>()

    fun getProductsFromCollectionId(collectionId: Long) {
        shopifyApiRepository.getProductFromCollection(collectionId).enqueue(object :
            Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {
                    collectionProduct.value = response.body()
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
}