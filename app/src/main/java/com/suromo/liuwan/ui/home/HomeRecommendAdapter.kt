package com.suromo.liuwan.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suromo.liuwan.R
import com.suromo.liuwan.data.home.RecommendBean

class HomeRecommendAdapter(var list: MutableList<RecommendBean>): RecyclerView.Adapter<HomeRecommendAdapter.RecommendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        return RecommendViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_home_recommend_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        holder.img.setImageResource(list[position].imgRes)
        holder.like.setImageResource(list[position].like)
        holder.title.text = list[position].title
        holder.desc.text = list[position].desc
        holder.price.text = list[position].price.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class RecommendViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var img: ImageView = view.findViewById(R.id.recommendIvImg)
        var like: ImageView = view.findViewById(R.id.recommendIvLike)
        var title: TextView = view.findViewById(R.id.recommendTvTitle)
        var desc: TextView = view.findViewById(R.id.recommendTvDesc)
        var price: TextView = view.findViewById(R.id.recommendTvPrice)
    }

}