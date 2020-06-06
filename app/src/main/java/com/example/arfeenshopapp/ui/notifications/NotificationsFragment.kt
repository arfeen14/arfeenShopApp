package com.example.arfeenshopapp.ui.notifications

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arfeenshopapp.R
import com.example.arfeenshopapp.adapter.WenslijstAdapter
import data.ProductenRepository

import kotlinx.android.synthetic.main.product_info.view.*
import kotlinx.android.synthetic.main.wishlist_item.view.*
import models.Producten

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    val product = arrayListOf<Producten>()

    //    private val popularProductsAdapter =
    //    MainProductAdapter(product, onClickListener = this::clickOnPopularProduct)
    private val wenslijstAdapter =
        WenslijstAdapter(product)

    //database
    private lateinit var productenRepository: ProductenRepository


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(requireActivity())[NotificationsViewModel::class.java]

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        val rvWenslijst: RecyclerView = root.findViewById(R.id.rvWenslijst1)

        rvWenslijst.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        rvWenslijst.adapter = wenslijstAdapter

        productenRepository = ProductenRepository(requireContext())
        getProductenFromDatabase()

        return root
    }

    //methode voor database
    private fun getProductenFromDatabase() {
        val producten = productenRepository.getAllProducten()
        this.product.clear()
        this.product.addAll(producten)
        wenslijstAdapter.notifyDataSetChanged()
    }

}


