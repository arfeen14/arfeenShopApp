package com.example.arfeenshopapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.arfeenshopapp.MainActivity
import com.example.arfeenshopapp.R
import com.example.arfeenshopapp.adapter.CategoryAdapter
import com.example.arfeenshopapp.ui.CategoryFragment
import com.example.arfeenshopapp.ui.notifications.NotificationsFragment
import com.example.arfeenshopapp.ui.notifications.NotificationsViewModel
import data.ProductenRepository
import kotlinx.android.synthetic.main.product_info.*
import kotlinx.android.synthetic.main.product_info.view.*
import kotlinx.android.synthetic.main.product_item.view.*
import kotlinx.android.synthetic.main.wishlist_item.*
import kotlinx.android.synthetic.main.wishlist_item.view.*
import models.Product
import models.Producten

class ProductInfoFragment : Fragment() {

    private lateinit var productInfoViewModel: ProductInfoViewModel
    var geselecteerdeProduct: Producten? = null

    private lateinit var productenRepository: ProductenRepository

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        productInfoViewModel = ViewModelProviders.of(this).get(ProductInfoViewModel::class.java)


        val root = inflater.inflate(R.layout.product_info, container, false)


        //hier laad de info van het product
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            root.tvProducInfo_info.text =
                Html.fromHtml(geselecteerdeProduct!!.bodyHtml, Html.FROM_HTML_MODE_LEGACY)
        } else {
            root.tvProducInfo_info.text = Html.fromHtml(geselecteerdeProduct!!.bodyHtml)
        }

        /**
         * Comment deze code weg als je het wilt laten werken.
         */
//        Glide.with(root.context).load(geselecteerdeProduct!!.imagePath.productImgPath)
//            .into(root.imgProduct_info)



        root.tvProduct_info_name.text = "€ " + geselecteerdeProduct!!.variants[0].productPrice

        productenRepository = ProductenRepository(requireContext())


        root.btnAddToWishList.setOnClickListener() {
            //hier moet ik proberen een product toe te voegen
            addProduct()
        }


        return root
    }

    fun addProduct() {
        productenRepository.insertProducten(geselecteerdeProduct!!)
    }


}