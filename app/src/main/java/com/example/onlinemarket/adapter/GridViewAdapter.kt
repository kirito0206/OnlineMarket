package com.example.onlinemarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.ItemFenquGridLayoutBinding

class GridViewAdapter(private val picList:MutableList<Int>,private val nameList:MutableList<String>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var binding = DataBindingUtil.inflate<ItemFenquGridLayoutBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_fenqu_grid_layout,
            parent,
            false
        )
        binding.pic = picList[position]
        binding.name = nameList[position]
        return binding.root
    }

    override fun getItem(position: Int): Any {
        return nameList[position]
    }

    override fun getItemId(position: Int): Long = position.toLong()
    override fun getCount(): Int = nameList.size
}