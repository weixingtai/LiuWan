package com.suromo.liuwan.ui.discovery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suromo.liuwan.R
import com.suromo.liuwan.data.model.Recommend

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/30
 * desc  : TODO
 */
class WalkAdapter (var list: MutableList<Recommend>): RecyclerView.Adapter<WalkAdapter.WalkViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalkViewHolder {
        return WalkViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_walk_item,parent,false))
    }

    override fun onBindViewHolder(holder: WalkViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class WalkViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var img: ImageView = view.findViewById(R.id.recommendIvImg)
        var like: ImageView = view.findViewById(R.id.recommendIvLike)
        var title: TextView = view.findViewById(R.id.recommendTvTitle)
        var desc: TextView = view.findViewById(R.id.recommendTvDesc)
        var price: TextView = view.findViewById(R.id.recommendTvPrice)
    }

}