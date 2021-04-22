package com.suromo.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : Activity基类
 */
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initView()
        initData()
    }

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()

}