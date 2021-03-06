package com.example.onlinemarket.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.ItemRecommendBinding
import com.example.onlinemarket.model.bean.Product


class RecommendAdapter(var lists: ArrayList<Product>) : RecyclerView.Adapter<RecommendAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding : ItemRecommendBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_recommend,
                parent,
                false)
        return ViewHolder(mBinding)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lists[position])
    }

    class ViewHolder(private val mBinding : ItemRecommendBinding) : RecyclerView.ViewHolder(mBinding.root){

        lateinit var imageView : ImageView

        fun bind(product : Product){
            imageView = mBinding.itemActionIv
            mBinding.data = product
            mBinding.executePendingBindings()
        }
    }

}