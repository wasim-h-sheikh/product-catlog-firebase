package com.qstest.presentation.product

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.qstest.R
import com.qstest.data.model.Product
import com.qstest.databinding.ProductListItemBinding

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {
    private val productList= ArrayList<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding: ProductListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.product_list_item, parent, false
        )
        return ProductViewHolder(binding)
    }
    fun setList(list:List<Product>){
        productList.addAll(list)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind(productList[position])
    }

    inner class ProductViewHolder(private val binding: ProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun onBind(product: Product){
                binding.apply {
                    this.product=product
                }
            }
        }

}

