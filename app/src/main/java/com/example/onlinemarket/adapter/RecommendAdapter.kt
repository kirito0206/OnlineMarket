package com.example.onlinemarket.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.ItemActionBinding
import com.example.onlinemarket.model.bean.Product
import com.example.onlinemarket.utils.DatabindingHelper
import kotlinx.android.synthetic.main.item_action.view.*

class RecommendAdapter(lists: ArrayList<Product>) : RecyclerView.Adapter<RecommendAdapter.ViewHolder>() {
    var list = lists
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding : ItemActionBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_action,
                parent,
                false)
        return ViewHolder(mBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(private val mBinding : ItemActionBinding) : RecyclerView.ViewHolder(mBinding.root){

        fun bind(product : Product){
            mBinding.data = product
            mBinding.executePendingBindings()
        }
    }

}