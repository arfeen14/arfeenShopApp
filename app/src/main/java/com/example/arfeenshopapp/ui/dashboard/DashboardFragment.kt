package com.example.arfeenshopapp.ui.dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.arfeenshopapp.R
import com.example.arfeenshopapp.adapter.MainProductAdapter
import models.Collections
import models.Product

private const val MODEL = "model"

class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel

    private val popularProducts = arrayListOf<Product.Producten>()
    private val popularProductsAdapter =
        MainProductAdapter(popularProducts, onClickListener = this::clickOnPopularProduct)

    private val collections = arrayListOf<Collections.Collection>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dashboardViewModel =
            ViewModelProviders.of(requireActivity())[DashboardViewModel::class.java]
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val rvPopularProducten: RecyclerView = root.findViewById(R.id.rvPopularProducts)
        //rv van category
        val rvCategory: RecyclerView = root.findViewById(R.id.rvCategories)

        // connect the adapters to the recyclerviews
        rvPopularProducten.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        rvPopularProducten.adapter = popularProductsAdapter

        rvCategory.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)


        loadData()

        return root
    }

    fun loadData() {

        dashboardViewModel.getProducts()

        popularProducts.clear()
        collections.clear()

        dashboardViewModel.product.observe(
            viewLifecycleOwner,
            Observer {
                this.popularProducts.clear()
                popularProducts.addAll(it.products)
                popularProductsAdapter.notifyDataSetChanged()
            })

        //category gedeelte
        dashboardViewModel.category.observe(
            viewLifecycleOwner,
            Observer {

            }
        )
    }

    private fun clickOnPopularProduct(view: View, product: Product.Producten) {
//        laat de product info scherm zien waar je op de add to wish list kan cliken
    }

    private fun clickOnCategory(view: View, product: Product.Producten) {
//        dit stuurt je door naar de category afdeling
    }


}
