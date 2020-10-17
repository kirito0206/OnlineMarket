package com.example.onlinemarket.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.onlinemarket.R
import com.nostra13.universalimageloader.core.ImageLoader
import com.zhouwei.mzbanner.holder.MZViewHolder


class BannerViewHolder : MZViewHolder<String?> {
    private var mImageView: ImageView? = null
    override fun createView(context: Context?): View {
        // 返回页面布局
        val view: View = LayoutInflater.from(context).inflate(R.layout.banner_item, null)
        mImageView = view.findViewById(R.id.banner_image) as ImageView
        return view
    }

    override fun onBind(context: Context?, position: Int, data: String?) {
        ImageLoader.getInstance().displayImage(data,mImageView)
    }
}