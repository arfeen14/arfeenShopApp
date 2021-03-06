package com.example.arfeenshopapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arfeenshopapp.R
import kotlinx.android.synthetic.main.wishlist_item.view.*
import models.Product
import models.Producten

class WenslijstAdapter(
//    private val product: List<Producten>
    private val wishlist: ArrayList<Producten>
) : RecyclerView.Adapter<WenslijstAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.wishlist_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return wishlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(wishlist[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Producten) {

            itemView.tvWenslijst.text = product.productNaam


        }
    }


}