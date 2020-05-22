package com.example.arfeenshopapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arfeenshopapp.R
import kotlinx.android.synthetic.main.categoryrv_item.view.*
import models.Collections


class CategoryAdapter(
    private val category: List<Collections.Collection>,
    private val onClickListner: (View, Collections.Collection) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CategoryAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.categoryrv_item, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return category.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(category[position])

        holder.itemView.setOnClickListener { view ->
            onClickListner.invoke(view, category[position])
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: Collections.Collection) {

//            Glide.with(itemView).load(category.collectionImage.collectionImgPath)
//                .into(itemView.ivCategoryImage)
//            itemView.tvCategoryText.text = category.collectionTitle

            Glide.with(itemView)
                .load(category.collectionImage)
                .into(itemView.ivCategoryImage)
            itemView.tvCategoryText.text = category.collectionTitle
        }
    }
}