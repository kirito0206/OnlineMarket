package com.example.onlinemarket.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.onlinemarket.adapter.BannerViewHolder
import com.nostra13.universalimageloader.core.ImageLoader
import com.zhouwei.mzbanner.MZBannerView
import com.zhouwei.mzbanner.holder.MZHolderCreator

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

        @BindingAdapter("bannerData")
        @JvmStatic
        fun loadBannerView(iv: View, bannerData: ArrayList<String>) {
            if (bannerData == null || iv == null)
                return
            (iv as MZBannerView<String>).setPages(bannerData) {BannerViewHolder()}
        }

        /*@BindingAdapter("gridlist")
        @JvmStatic
        fun loadGridView(gridView : GridView,animesList:MutableList<AnimeData>?) {
            if (animesList == null){
                debug("animelist : null")
                return
            }
            gridView.adapter = GridAdapter(animesList)
        }*/

    }
}