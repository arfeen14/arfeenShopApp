package com.example.arfeenshopapp.ui.notifications

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import models.Collections
import models.Product
import models.Producten
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shopify.api.ShopifyApiRepository

class NotificationsViewModel(application: Application) : AndroidViewModel(application) {
    val wishlist = arrayListOf<Producten>()

    fun getWishList(): ArrayList<Producten> {
        return wishlist
    }


}