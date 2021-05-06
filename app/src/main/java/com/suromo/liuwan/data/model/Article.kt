package com.suromo.liuwan.data.model

import java.io.Serializable

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : 文章实体类
 */
data class Article(
    val id: Int,
    val avatar: String,
    val name: String,
    val time: String,
    val title: String,
    val content: String,
    val img: MutableList<String>,
    val like: Boolean,
    val share: Boolean,
    val collect: Boolean,
    val commentNum: Int,
    val collectNum: Int,
    val comment: String,
    val userId: Int
) : Serializable