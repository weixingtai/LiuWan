package com.suromo.liuwan.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.suromo.core.base.BaseVMFragment
import com.suromo.liuwan.R
import com.suromo.liuwan.databinding.FragmentNotificationsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : 通知界面
 */
class NotificationsFragment : BaseVMFragment<FragmentNotificationsBinding>(R.layout.fragment_notifications) {

    private val notificationsViewModel by viewModel<NotificationsViewModel>()

    override fun initView() {

    }

    override fun initData() {

    }

    override fun startObserve() {
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.notificationsTv.text = it
        })
    }


}