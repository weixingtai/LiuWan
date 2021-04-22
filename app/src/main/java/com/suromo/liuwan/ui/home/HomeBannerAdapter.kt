package com.suromo.liuwan.ui.home

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.suromo.liuwan.data.model.BannerBean
import com.youth.banner.adapter.BannerAdapter

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
class HomeBannerAdapter(var bannerList: MutableList<BannerBean>) : BannerAdapter<BannerBean, HomeBannerAdapter.BannerViewHolder>(bannerList) {

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val imageView = ImageView(parent.context)
        imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(imageView)
    }

    override fun onBindView(holder: BannerViewHolder, bean: BannerBean, position: Int, size: Int) {
        bean.imgRes.let { holder.imageView.setImageResource(it) }
    }

    inner class BannerViewHolder(var imageView: ImageView) : RecyclerView.ViewHolder(imageView)

}