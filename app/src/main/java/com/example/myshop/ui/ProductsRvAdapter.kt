package com.example.myshop.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.model.Products
import com.example.myshop.databinding.ProductsListsBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductsRvAdapter(var products: List<Products>) :RecyclerView.Adapter<ProductsRvAdapter.ProductViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val binding=ProductsListsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
      val currentProducts=products.get(position)
        val binding=holder.binding
        binding.tvbrand.text=currentProducts.brand
        binding.tvstock.text=currentProducts.stock.toString()
        binding.tvcategory.text=currentProducts.category
        binding.tvid.text=currentProducts.id.toString()
        binding.tvdescription.text=currentProducts.description
        binding.tvprice.text=currentProducts.price.toString()
        binding.tvthiumbnail.text=currentProducts.thumbnail
        binding.tvtitle.text=currentProducts.tittle
        Picasso
            .get().load(currentProducts.thumbnail)
            .resize(80,80)
            .centerInside()
            .transform(CropCircleTransformation())
            .into(binding.ivImage)

    }

    override fun getItemCount(): Int {
        return products.size

    }
    class ProductViewHolder(var  binding: ProductsListsBinding):RecyclerView.ViewHolder(binding.root)

}