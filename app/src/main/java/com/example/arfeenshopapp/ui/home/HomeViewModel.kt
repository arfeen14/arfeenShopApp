package com.example.arfeenshopapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Een wenslijst app waar je:\n" +
                " 1. producten kan zien die worden ingeladen vanuit shopify\n" +
                " 2.Een product kan toevoegen aan je wenslijst en verwijderen.\n " +
                "3. Product informatie kan bekijken van het product dat je wilt zien."
    }
    val text: LiveData<String> = _text
}