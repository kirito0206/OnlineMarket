package com.example.onlinemarket.utils

import android.util.Log
import android.view.View
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarket.adapter.BannerViewHolder
import com.example.onlinemarket.adapter.GridViewAdapter
import com.example.onlinemarket.adapter.RecommendAdapter
import com.example.onlinemarket.model.bean.Product
import com.nostra13.universalimageloader.core.ImageLoader
import com.zhouwei.mzbanner.MZBannerView

class DatabindingHelper {

    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(iv: ImageView, url: String?) {
            ImageLoader.getInstance().displayImage(url, iv)
        }

        @BindingAdapter("resId")
        @JvmStatic
        fun loadImageResource(iv: ImageView, resId: Int) {
            iv.setImageResource(resId)
        }


        @BindingAdapter("toolbar")
        @JvmStatic
        fun toolbarMenu(toolbar: Toolbar, menu: Int) {
            toolbar.inflateMenu(menu)
        }

        @BindingAdapter("username")
        @JvmStatic
        fun loadusername(textView: TextView, name: String) {
            textView.setText(name)
        }

        @BindingAdapter(value = ["picList", "nameList"], requireAll = true)
        @JvmStatic
        fun loadGridView(
                gridView: GridView,
                picList: MutableList<Int>?,
                nameList: MutableList<String>?
        ) {
            if (picList.isNullOrEmpty() || nameList.isNullOrEmpty())
                return
            gridView.adapter = GridViewAdapter(picList, nameList)
        }

        @BindingAdapter("productList")
        @JvmStatic
        fun loadRecyclerView(
                recyclerView: RecyclerView,
                productList: MutableList<Product>?
        ) {
            if (productList.isNullOrEmpty())
                return
            val layoutManager = LinearLayoutManager(recyclerView.context)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = RecommendAdapter(productList as ArrayList<Product>)
        }
    }
}