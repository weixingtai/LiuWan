package com.suromo.liuwan.data.model

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : 推荐实体类
 */
data class Recommend(
    val imgRes: Int,
    val like: Int,
    val title: String,
    val desc: String,
    val price: Double
)
