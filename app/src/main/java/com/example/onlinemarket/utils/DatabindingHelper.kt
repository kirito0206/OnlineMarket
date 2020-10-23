package com.example.onlinemarket.utils

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.onlinemarket.R
import com.example.onlinemarket.adapter.ActionAdapter
import com.example.onlinemarket.adapter.GridViewAdapter
import com.example.onlinemarket.adapter.RecommendAdapter
import com.example.onlinemarket.model.bean.Action
import com.example.onlinemarket.model.bean.Product
import com.example.onlinemarket.ui.LoginActivity
import com.example.onlinemarket.ui.home.HomeViewModel
import com.nostra13.universalimageloader.core.ImageLoader
import org.litepal.LitePal

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
            toolbar.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.logout ->{
                        val intent= Intent(toolbar.context,LoginActivity::class.java)
                        (toolbar.context as Activity).startActivity(intent)
                        return@setOnMenuItemClickListener true
                    }
                    else ->{return@setOnMenuItemClickListener false}
                }
            }
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
            recyclerView.adapter = ActionAdapter(productList as ArrayList<Product>)
        }

        @BindingAdapter("recommendList")
        @JvmStatic
        fun loadRecommendView(
            recyclerView: RecyclerView,
            productList: MutableList<Product>?
        ) {
            if (productList.isNullOrEmpty())
                return

            val layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = RecommendAdapter(productList as ArrayList<Product>)
        }

        @BindingAdapter("refreshData")
        @JvmStatic
        fun refresh(
            view: SwipeRefreshLayout,
            refreshData : HomeViewModel
        ) {
            view.setOnRefreshListener {
                view.isRefreshing = false
                refreshData.loadDatas()
            }
        }

        @BindingAdapter("isVisiable")
        @JvmStatic
        fun setVisiable(
            view: View,
            productList: MutableList<Product>?
        ) {
            if(productList.isNullOrEmpty())
                view.visibility = View.GONE
            else
                view.visibility = View.VISIBLE
        }

        @BindingAdapter("BackGround")
        @JvmStatic
        fun setBackGround(
                linear : LinearLayout,
                actionType : Int
        ){
            when(actionType) {
                0 -> {
                    linear.setBackgroundResource(R.drawable.recommend_background)
                }
                1 -> {
                    linear.setBackgroundResource(R.drawable.midautumn_recommend)
                }
                2 -> {
                    linear.setBackgroundResource(R.drawable.chrismas_recommend_ls)
                }
            }
        }

        @BindingAdapter("TextColor")
        @JvmStatic
        fun setTextColor(
                tv : TextView,
                actionType : Int
        ){
            when(actionType) {
                0,2 ->{
                    tv.setTextColor(Color.parseColor("#FFFFFF"))
                }
                1 -> {
                    tv.setTextColor(Color.parseColor("#DA941F"))
                }
            }
        }

        @BindingAdapter("priceType")
        @JvmStatic
        fun setTextType(
            view: TextView,
            flag : Boolean
        ) {
            if (flag) {
                view.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
                view.paint.isAntiAlias = true //抗锯齿
            }
        }
    }
}