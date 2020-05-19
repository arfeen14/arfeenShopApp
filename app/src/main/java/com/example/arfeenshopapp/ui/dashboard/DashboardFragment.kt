package com.example.arfeenshopapp.ui.dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arfeenshopapp.MainActivity

import com.example.arfeenshopapp.R
import com.example.arfeenshopapp.adapter.MainProductAdapter
import models.Product

private const val MODEL = "model"

class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel

    private val popularProducts = arrayListOf<Product.Producten>()
    private val popularProductsAdapter =
        MainProductAdapter(popularProducts, onClickListener = this::clickOnPopularProduct)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dashboardViewModel =
            ViewModelProviders.of(requireActivity())[DashboardViewModel::class.java]
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val rvPopularProducten: RecyclerView = root.findViewById(R.id.rvPopularProducts)

        // connect the adapters to the recyclerviews
        rvPopularProducten.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        rvPopularProducten.adapter = popularProductsAdapter

        loadData()

        return root
    }

    fun loadData() {

        dashboardViewModel.getProducts()

        popularProducts.clear()

        dashboardViewModel.product.observe(
            viewLifecycleOwner,
            Observer {
                this.popularProducts.clear()
                popularProducts.addAll(it.products)
                popularProductsAdapter.notifyDataSetChanged()
            })

    }

    private fun clickOnPopularProduct(view: View, product: Product.Producten) {


    }


}
