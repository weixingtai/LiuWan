package com.suromo.liuwan.ui.discovery

import androidx.lifecycle.Observer
import com.suromo.core.base.BaseVMFragment
import com.suromo.liuwan.R
import com.suromo.liuwan.databinding.FragmentDiscoveryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
class DiscoveryFragment : BaseVMFragment<FragmentDiscoveryBinding>(R.layout.fragment_discovery) {

    private val discoveryViewModel by viewModel<DiscoveryViewModel>()



    override fun initView() {

    }

    override fun initData() {

    }

    override fun startObserve() {
        discoveryViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.discoveryTv.text = it
        })
    }


}