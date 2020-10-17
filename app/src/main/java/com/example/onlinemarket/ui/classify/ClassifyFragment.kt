package com.example.onlinemarket.ui.classify

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.FragmentClassifyBinding

class ClassifyFragment : Fragment() {

    private lateinit var classifyBinding : FragmentClassifyBinding
    private lateinit var classifyViewModel: ClassifyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        classifyViewModel =
            ViewModelProviders.of(this).get(ClassifyViewModel::class.java)
        classifyBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_classify,container,false)
        classifyBinding.data = classifyViewModel
        classifyBinding.lifecycleOwner = this
        return classifyBinding.root
    }

}