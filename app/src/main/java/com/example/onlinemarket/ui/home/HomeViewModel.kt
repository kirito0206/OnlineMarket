package com.example.onlinemarket.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinemarket.R
import com.example.onlinemarket.model.bean.BannerResponse
import com.example.onlinemarket.model.network.repository.MarketRepository
import com.example.onlinemarket.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    private val marketRepository by lazy { MarketRepository() }

    val picList = MutableLiveData<ArrayList<Int>>().apply { value = arrayListOf() }
    val nameList = MutableLiveData<ArrayList<String>>().apply { value = arrayListOf() }

    var bannerPic = MutableLiveData<ArrayList<String>>().apply { value = arrayListOf() }
    private val response = MutableLiveData<BannerResponse>().also { loadDatas() }
    var bannerType = MutableLiveData<Int>()

    fun loadDatas() {
        initGridData()
        mimic()
        GlobalScope.launch(Dispatchers.Main) {
            //initBanners()

        }
        // Do an asynchronous operation to fetch users.
    }

    private fun initGridData() {
        picList.value?.add(R.drawable.pic0)
        picList.value?.add(R.drawable.pic0)
        picList.value?.add(R.drawable.pic0)
        picList.value?.add(R.drawable.pic0)
        picList.value?.add(R.drawable.pic0)
        picList.value?.add(R.drawable.pic0)
        picList.value?.add(R.drawable.pic0)
        picList.value?.add(R.drawable.pic0)
        picList.value?.add(R.drawable.pic0)
        picList.value?.add(R.drawable.pic0)
        nameList.value?.add("水果")
        nameList.value?.add("蔬菜")
        nameList.value?.add("肉禽蛋品")
        nameList.value?.add("海鲜水产")
        nameList.value?.add("粮油调味")
        nameList.value?.add("熟食卤味")
        nameList.value?.add("冰品面点")
        nameList.value?.add("牛奶面包")
        nameList.value?.add("酒水冲饮")
        nameList.value?.add("休闲零食")
    }

    fun mimic(){
        bannerPic.value?.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1602921057684&di=c9314f32efb607825da2b8f78edbf0f6&imgtype=0&src=http%3A%2F%2Fimg1.qunarzz.com%2Ftravel%2Fd3%2F1505%2Fba%2Ffed9499636ea1b.jpg_r_720x480x95_fbc7fd72.jpg")
        bannerPic.value?.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1176503144,1033294539&fm=26&gp=0.jpg")
        bannerPic.value?.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1470145925,1579524748&fm=26&gp=0.jpg")

    }

    private suspend fun initBanners() {
        val result = withContext(Dispatchers.IO){
            marketRepository.getBanners()
        }
        response.value = result
        if (result!!.status == 0){
            //bannerType = result
            bannerPic.value = result.data.pictures as ArrayList<String>
        }
    }
}