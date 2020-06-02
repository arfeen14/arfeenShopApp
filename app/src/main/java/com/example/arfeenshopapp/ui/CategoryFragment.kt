package com.example.arfeenshopapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arfeenshopapp.R
import com.example.arfeenshopapp.adapter.MainProductAdapter
import com.example.arfeenshopapp.ui.home.ProductInfoFragment
import kotlinx.android.synthetic.main.categoryrv_item.view.*
import models.Producten

class CategoryFragment : Fragment() {

    private val producten = arrayListOf<Producten>()
    private val productAdapter = MainProductAdapter(producten, onClickListener = this::clickProduct)

    private lateinit var categoryOverviewModel: CategoryOverviewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        categoryOverviewModel = ViewModelProviders.of(this).get(CategoryOverviewModel::class.java)

        var root = inflater.inflate(R.layout.category_page, container, false)

        val categoryId = requireArguments().getLong("Collection_id")
        val categoryName = requireArguments().getString("Collection_name")

        root.tvCategoryText.text = categoryName

        val rvProduct: RecyclerView = root.findViewById(R.id.rvWenslijst1)
        rvProduct.layoutManager =
            GridLayoutManager(this.context, 2, LinearLayoutManager.VERTICAL, false)
        rvProduct.setHasFixedSize(true)
        rvProduct.adapter = productAdapter

        categoryOverviewModel.getProductsFromCollectionId(categoryId)
        categoryOverviewModel.collectionProduct.observe(viewLifecycleOwner, Observer {
            this.producten.clear()
            if (it.products.isEmpty()) {
                root.tvCategoryText.text = "no products found"
            }

//            for (product in it.products) {
//                if (product.variants == null) {
//                    product.variants = listOf(Producten.va)
//                }
//                producten.add(product)
//            }


            productAdapter.notifyDataSetChanged()
        })

        productAdapter.notifyDataSetChanged()
        return root

    }

    private fun clickProduct(view: View, product: Producten) {
        val transaction = requireFragmentManager().beginTransaction()
        val productInfoFragment = ProductInfoFragment()

        productInfoFragment.geselecteerdeProduct = product

        transaction.replace(R.id.nav_host_fragment, productInfoFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}