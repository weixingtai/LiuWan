package com.suromo.liuwan.ui.discovery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.suromo.core.base.BaseViewModel

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
class DiscoveryViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is discovery Fragment"
    }
    val text: LiveData<String> = _text
}