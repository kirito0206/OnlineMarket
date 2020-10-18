package com.example.onlinemarket.ui.home
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinemarket.R
import com.example.onlinemarket.model.bean.BannerResponse
import com.example.onlinemarket.model.bean.Product
import com.example.onlinemarket.model.network.repository.MarketRepository
import com.example.onlinemarket.utils.debug
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeViewModel : ViewModel() {

    private val marketRepository by lazy { MarketRepository() }

    val picList = MutableLiveData<ArrayList<Int>>().apply { value = arrayListOf() }
    val nameList = MutableLiveData<ArrayList<String>>().apply { value = arrayListOf() }
    val productList = MutableLiveData<ArrayList<Product>>().apply { value = arrayListOf() }
    var bannerPic = MutableLiveData<ArrayList<String>>().apply { value = arrayListOf() }
    private val response = MutableLiveData<BannerResponse>().also { loadDatas() }
    var bannerType = MutableLiveData<Int>()

    fun loadDatas() {
        initGridData()
        initRecyclerData()
        GlobalScope.launch(Dispatchers.Main) {
            initBanners()
        }
    }

    private fun initRecyclerData(){
        val p = Product(1,"cheap!","grape","https://tu1.whhost.net/uploads/20180204/22/1517756051-LHXmAdKRFo.jpg",5.98)
        productList.value?.add(p)
        productList.value?.add(p)
        productList.value?.add(p)
        val q = Product(1,"蛋挞","danta","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3557750652,71235332&fm=26&gp=0.jpg",5.98)
        productList.value?.add(q)
        productList.value?.add(q)
        productList.value?.add(q)
        productList.value?.add(q)
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
            //bannerType = result
            if (result.data.message.picture != null) {
                bannerPic.value = response!!.value!!.data.message.picture
            }
        }
    }
}