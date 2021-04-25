package com.suromo.liuwan.ui.user

import androidx.lifecycle.Observer
import com.suromo.core.base.BaseVMFragment
import com.suromo.liuwan.R
import com.suromo.liuwan.databinding.FragmentUserBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : 用户模块界面
 */
class UserFragment : BaseVMFragment<FragmentUserBinding>(R.layout.fragment_user) {

    private val userViewModel by viewModel<UserViewModel>()

    override fun initView() {

    }

    override fun initData() {

    }

    override fun startObserve() {
        userViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.userTv.text = it
        })
    }
}