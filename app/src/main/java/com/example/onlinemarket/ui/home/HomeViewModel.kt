package com.example.onlinemarket.ui.home
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinemarket.R
import com.example.onlinemarket.model.bean.BannerResponse
import com.example.onlinemarket.model.bean.Product
import com.example.onlinemarket.model.network.repository.MarketRepository
import com.example.onlinemarket.utils.SPUtils
import com.example.onlinemarket.utils.debug
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeViewModel : ViewModel() {

    private val marketRepository by lazy { MarketRepository() }

    //GridView
    val picList = MutableLiveData<ArrayList<Int>>().apply { value = arrayListOf() }
    val nameList = MutableLiveData<ArrayList<String>>().apply { value = arrayListOf() }

    //推荐商品
    val recommendList = MutableLiveData<ArrayList<Product>>().apply { value = arrayListOf() }

    //活动商品
    val productList = MutableLiveData<ArrayList<Product>>().apply { value = arrayListOf() }

    //轮播图
    var bannerPic = MutableLiveData<ArrayList<String>>().apply { value = arrayListOf() }
    var bannerType = MutableLiveData<Int>().apply { value = 0 }
    private val response = MutableLiveData<BannerResponse>().also { loadDatas() }

    fun loadDatas() {
        initGridData()
        GlobalScope.launch(Dispatchers.Main) {
            initBanners()
            initRecyclerData()
            //if (SPUtils.account.isNotEmpty())
            //    initRecommend()
        }
    }

    private suspend fun initRecyclerData(){
        val result = withContext(Dispatchers.IO){
            marketRepository.getProducts()
        }
        debug(result.toString())
        if (result!!.status == 0){
            if (result.data.products != null) {
                productList.value = result.data.products as ArrayList<Product>
            }
        }
    }

    private fun initGridData() {
        picList.value?.add(R.drawable.pic0)
        picList.value?.add(R.drawable.pic1)
        picList.value?.add(R.drawable.pic2)
        picList.value?.add(R.drawable.pic3)
        picList.value?.add(R.drawable.pic4)
        picList.value?.add(R.drawable.pic5)
        picList.value?.add(R.drawable.pic6)
        picList.value?.add(R.drawable.pic7)
        picList.value?.add(R.drawable.pic8)
        picList.value?.add(R.drawable.pic9)
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

    private suspend fun initBanners() {
        val result = withContext(Dispatchers.IO){
            marketRepository.getBanners()
        }
        response.value = result
        debug(result.toString())
        if (result!!.status == 0){
            bannerType.value = result.data.message.type?:0
            if (result.data.message.picture != null) {
                bannerPic.value = response!!.value!!.data.message.picture
            }
        }
    }

    private suspend fun initRecommend() {
        val result = withContext(Dispatchers.IO){
            marketRepository.getRecommendProducts(SPUtils.token)
        }
        debug(result.toString())
        if (result!!.status == 0){
            if (result.data.message != null) {
                recommendList.value = result.data.message as ArrayList<Product>
            }
        }
    }
}