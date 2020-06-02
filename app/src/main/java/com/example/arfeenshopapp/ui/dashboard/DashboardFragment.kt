package com.example.arfeenshopapp.ui.dashboard


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arfeenshopapp.MainActivity

import com.example.arfeenshopapp.R
import com.example.arfeenshopapp.adapter.CategoryAdapter
import com.example.arfeenshopapp.adapter.MainProductAdapter
import com.example.arfeenshopapp.ui.CategoryFragment
import com.example.arfeenshopapp.ui.home.ProductInfoFragment
import com.example.arfeenshopapp.ui.notifications.NotificationsViewModel
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.main_category_page.*
import kotlinx.android.synthetic.main.product_info.*
import models.Category
import models.Collections
import models.Product
import models.Producten

private const val MODEL = "model"

class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var notificationsViewModel: NotificationsViewModel

    private val popularProducts = arrayListOf<Producten>()
    private val popularProductsAdapter =
        MainProductAdapter(popularProducts, onClickListener = this::clickOnPopularProduct)

    private val category = arrayListOf<Collections.Collection>()
    private val categoryAdapter = CategoryAdapter(category, onClickListner = this::clickOnCategory)

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
        rvCategory.adapter = categoryAdapter


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


    private fun clickOnPopularProduct(view: View, product: Producten) {
//        laat de product info scherm zien waar je op de add to wish list kan cliken

        val transaction = requireFragmentManager().beginTransaction()
        val productInfoFragment = ProductInfoFragment()

        productInfoFragment.geselecteerdeProduct = product

        transaction.replace(R.id.nav_host_fragment, productInfoFragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    private fun clickOnCategory(view: View, category: Collections.Collection) {


    }

}
