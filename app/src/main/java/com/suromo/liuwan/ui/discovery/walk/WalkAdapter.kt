package com.suromo.liuwan.ui.discovery.walk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView
import com.suromo.liuwan.R
import com.suromo.liuwan.data.model.Article
import com.suromo.liuwan.data.model.Recommend

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/30
 * desc  : TODO
 */
class WalkAdapter (var list: MutableList<Article>): RecyclerView.Adapter<WalkAdapter.WalkViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalkViewHolder {
        return WalkViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_walk_item,parent,false))
    }

    override fun onBindViewHolder(holder: WalkViewHolder, position: Int) {
        holder.avatar.setImageResource(R.drawable.ic_wechat)
        holder.like.setImageResource(R.drawable.ic_banner_demo2)
        holder.name.text = list[position].name
        holder.time.text = list[position].time
        holder.title.text = list[position].title
        holder.content.text = list[position].content
        holder.commentNum.text = list[position].commentNum.toString()
        holder.collectNum.text = list[position].collectNum.toString()

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class WalkViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var avatar: RoundedImageView = view.findViewById(R.id.walkRivAvatar)
        var name: TextView = view.findViewById(R.id.walkTvName)
        var time: TextView = view.findViewById(R.id.walkTvTime)
        var img: RoundedImageView = view.findViewById(R.id.walkIvImg)
        var title: TextView = view.findViewById(R.id.walkTvTitle)
        var content: TextView = view.findViewById(R.id.walkTvContent)
        var like: ImageView = view.findViewById(R.id.walkIvLike)
        var share: ImageView = view.findViewById(R.id.walkIvShare)
        var commentNum: TextView = view.findViewById(R.id.walkTvCommentNum)
        var collectNum: TextView = view.findViewById(R.id.walkTvCollectNum)
        var comment: TextView = view.findViewById(R.id.walkTvComment)
        var addComment: TextView = view.findViewById(R.id.walkTvAddComment)
    }

}