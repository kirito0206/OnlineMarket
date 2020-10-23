package com.example.onlinemarket.ui.home

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rePaint(rec_tv)
        rePaint(rec_tv_activity)
    }

    private fun rePaint(tv: TextView) {
        //val typeface = Typeface.createFromAsset((this as Activity).assets,"王汉宗颜楷体繁.ttf")
        //rec_tv.setTypeface(typeface)
        val paint = tv.paint
        val width = paint.measureText(tv.text.toString())
        val textShader : Shader = LinearGradient(0f,0f,width,tv.textSize, intArrayOf(
                Color.parseColor("#C66344"),
                Color.parseColor("#F33D05"),
                Color.parseColor("#87402B")
        ),null,Shader.TileMode.REPEAT)
        tv.paint.shader = textShader
        tv.paint.isFakeBoldText = true
    }

    override fun onPause() {
        super.onPause()
        homeBinding.banner.pause()
    }

    override fun onResume() {
        super.onResume()
        homeBinding.banner.start()
    }
}