package com.example.onlinemarket.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeBinding : FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        homeBinding.data = homeViewModel
        homeBinding.lifecycleOwner = this
        return homeBinding.root
    }
}