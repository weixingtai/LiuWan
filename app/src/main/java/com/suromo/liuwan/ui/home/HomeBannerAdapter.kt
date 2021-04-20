package com.suromo.liuwan.ui.home

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.suromo.liuwan.data.home.BannerBean
import com.youth.banner.adapter.BannerAdapter


class HomeBannerAdapter(beanList: List<BannerBean?>?) : BannerAdapter<BannerBean?, HomeBannerAdapter.BannerViewHolder?>(beanList) {
    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val imageView = ImageView(parent.context)
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(imageView)
    }

    override fun onBindView(
        holder: HomeBannerAdapter.BannerViewHolder?,
        bean: BannerBean?,
        position: Int,
        size: Int
    ) {
        bean?.imgRes?.let { holder?.imageView?.setImageResource(it) }
    }

    inner class BannerViewHolder(var imageView: ImageView) : RecyclerView.ViewHolder(
        imageView
    )


}