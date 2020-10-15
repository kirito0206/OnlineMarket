package com.example.onlinemarket.utils

import android.content.Context
import android.graphics.Bitmap
import com.example.onlinemarket.R
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.ImageScaleType
import com.nostra13.universalimageloader.core.assist.QueueProcessingType
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer
import com.nostra13.universalimageloader.core.download.BaseImageDownloader
import com.nostra13.universalimageloader.utils.StorageUtils

object ImageLoaderUtils {
    /**
     * 初始化imageloader的配置
     * @param context
     */
    fun initConfigration(context: Context?) {
        val cacheDir = StorageUtils.getCacheDirectory(context) //缓存文件夹路径
        val config = ImageLoaderConfiguration.Builder(context)
            .threadPoolSize(3) //一般就是3,,,1-5
            .threadPriority(Thread.NORM_PRIORITY - 2) // default 设置当前线程的优先级,,,1-10
            .tasksProcessingOrder(QueueProcessingType.FIFO) // default
            .denyCacheImageMultipleSizesInMemory() //拒绝缓存加载内容相同但大小不同的图片
            .memoryCache(LruMemoryCache(2 * 1024 * 1024)) //可以通过自己的内存缓存实现
            .memoryCacheSize(2 * 1024 * 1024) // 内存缓存的最大值
            .memoryCacheSizePercentage(13) // default
            .diskCache(UnlimitedDiskCache(cacheDir)) // default 可以自定义缓存路径
            .diskCacheSize(50 * 1024 * 1024) // 50 Mb sd卡(本地)缓存的最大值
            .diskCacheFileCount(100) // 可以缓存的文件数量
            // default为使用HASHCODE对UIL进行加密命名， 还可以用MD5(new Md5FileNameGenerator())加密
            .diskCacheFileNameGenerator(HashCodeFileNameGenerator())
            .imageDownloader(BaseImageDownloader(context)) // default
            .imageDecoder(BaseImageDecoder(true)) // default
            .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
            .writeDebugLogs() // 打印debug log
            .build() //开始构建

        //初始化
        ImageLoader.getInstance().init(config)
    }

    //在加载之前复位一下显示
    //图片的质量
    ///是否考虑JPEG图像EXIF参数（旋转，翻转）
    val defautOption: DisplayImageOptions
        get() = DisplayImageOptions.Builder()
            .showImageForEmptyUri(R.drawable.notice_image_bg)
            .showImageOnFail(R.drawable.notice_image_bg)
            .showImageOnLoading(R.drawable.notice_image_bg)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
            .resetViewBeforeLoading(true) //在加载之前复位一下显示
            .bitmapConfig(Bitmap.Config.RGB_565) //图片的质量
            .considerExifParams(true) ///是否考虑JPEG图像EXIF参数（旋转，翻转）
            .build()//在加载之前复位一下显示
    //图片的质量
    ///是否考虑JPEG图像EXIF参数（旋转，翻转）
    //圆形显示

    /**
     * 圆形图片的配置
     * @return
     */
    val circleOption: DisplayImageOptions
        get() {
            return DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .resetViewBeforeLoading(true) //在加载之前复位一下显示
                .bitmapConfig(Bitmap.Config.RGB_565) //图片的质量
                .considerExifParams(true) ///是否考虑JPEG图像EXIF参数（旋转，翻转）
                .displayer(CircleBitmapDisplayer()) //圆形显示
                .build()
        }//在加载之前复位一下显示
    //图片的质量
    ///是否考虑JPEG图像EXIF参数（旋转，翻转）
    //指定加载圆角的大小

    /**
     * 加载圆角图片
     * @return
     */
    val boundOption: DisplayImageOptions
        get() {
            return DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .resetViewBeforeLoading(true) //在加载之前复位一下显示
                .bitmapConfig(Bitmap.Config.RGB_565) //图片的质量
                .considerExifParams(true) ///是否考虑JPEG图像EXIF参数（旋转，翻转）
                .displayer(RoundedBitmapDisplayer(20)) //指定加载圆角的大小
                .build()
        }
}