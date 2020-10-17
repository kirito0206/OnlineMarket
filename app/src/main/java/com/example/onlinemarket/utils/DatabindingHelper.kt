package com.example.onlinemarket.utils

import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import com.example.onlinemarket.adapter.GridViewAdapter
import com.nostra13.universalimageloader.core.ImageLoader

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
    }
}