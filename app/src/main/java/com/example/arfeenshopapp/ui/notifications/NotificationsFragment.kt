package com.example.arfeenshopapp.ui.notifications

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.arfeenshopapp.R
import com.example.arfeenshopapp.adapter.MainProductAdapter

import models.Producten

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    val product = arrayListOf<Producten>()
    private val popularProductsAdapter =
        MainProductAdapter(product, onClickListener = this::clickOnPopularProduct)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)


        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val rvWenslijst: RecyclerView = root.findViewById(R.id.rvWenslijst)


        rvWenslijst.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        rvWenslijst.adapter = popularProductsAdapter

        loadData()

        return root
    }


    fun loadData() {

        notificationsViewModel.getProducts()
        product.clear()

        notificationsViewModel.product.observe(
            viewLifecycleOwner,
            Observer {
                this.product.clear()
                product.addAll(it.products)
                popularProductsAdapter.notifyDataSetChanged()
            })
    }

    private fun clickOnPopularProduct(view: View, product: Producten) {


    }
}


