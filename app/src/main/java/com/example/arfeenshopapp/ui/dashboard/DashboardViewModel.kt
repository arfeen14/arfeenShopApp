package com.example.arfeenshopapp.ui.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import models.Category
import models.Product
import retrofit2.Call
import shopify.api.ShopifyApiRepository
import retrofit2.Callback
import retrofit2.Response


class DashboardViewModel(application: Application) : AndroidViewModel(application) {
    private val categoryRepository = ShopifyApiRepository()
    val collectionProduct = MutableLiveData<Product>()
    val error = MutableLiveData<String>()

    //we willen de producten met een id terug halen dus collectionId
    fun getProductId(collectionId: Long) {
        categoryRepository.getProductFromCollection(collectionId).enqueue(object :
            Callback<Product> {

            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) collectionProduct.value =
                    response.body()
                else error.value = "An error has occurred: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                error.value = t.message
            }

        })
    }
}