package com.example.onlinemarket.ui.cart

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.FragmentCartBinding
import com.example.onlinemarket.databinding.FragmentHomeBinding
import com.example.onlinemarket.ui.home.HomeViewModel

class CartFragment : Fragment() {

    private lateinit var cartBinding : FragmentCartBinding
    private lateinit var cartViewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cartViewModel =
            ViewModelProviders.of(this).get(CartViewModel::class.java)
        cartBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_cart,container,false)
        cartBinding.data = cartViewModel
        cartBinding.lifecycleOwner = this
        return cartBinding.root
    }

}