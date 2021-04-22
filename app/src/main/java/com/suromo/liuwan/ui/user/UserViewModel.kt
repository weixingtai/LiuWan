package com.suromo.liuwan.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
class UserViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is User Fragment"
    }
    val text: LiveData<String> = _text
}