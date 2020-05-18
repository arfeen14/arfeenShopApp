package com.example.arfeenshopapp.ui.dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import com.example.arfeenshopapp.R
import com.example.arfeenshopapp.adapter.MainProductAdapter
import models.Product


class DashboardFragment : Fragment() {
    lateinit var dashboardViewModel: DashboardViewModel
    private val popularProducts = arrayListOf<Product.Producten>()
    private val popularProductsAdapter =
        MainProductAdapter(popularProducts, onClickListener = this::clickOnPopularProduct)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)


        return root
    }

    private fun clickOnPopularProduct(view: View, product: Product.Producten) {


    }


}
