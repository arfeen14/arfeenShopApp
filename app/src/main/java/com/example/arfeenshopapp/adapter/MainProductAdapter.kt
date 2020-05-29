package com.example.arfeenshopapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arfeenshopapp.R
import kotlinx.android.synthetic.main.product_item.view.*
import models.Product
import models.Producten

class MainProductAdapter(
    private val product: List<Producten>,
    private val onClickListener: (View, Producten) -> Unit
) : RecyclerView.Adapter<MainProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainProductAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return product.size
    }

    override fun onBindViewHolder(holder: MainProductAdapter.ViewHolder, position: Int) {
        holder.bind(product[position])
        holder.itemView.setOnClickListener { view ->
            onClickListener.invoke(view, product[position])
        }
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Producten) {
            Glide.with(itemView).load(product.imagePath.productImgPath).into(itemView.ivProductImage)
            itemView.tvProductActivator.text = product.productNaam

            if (product.variants[0].productPrice.isNullOrEmpty()) {
                itemView.tvPrice.visibility = View.GONE
            } else {
                itemView.tvPrice.text = ("$" + product.variants[0].productPrice)
            }
        }
    }
}


