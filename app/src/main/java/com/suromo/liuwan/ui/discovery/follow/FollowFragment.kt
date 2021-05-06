package com.suromo.liuwan.ui.discovery.follow

import com.suromo.core.base.BaseVMFragment
import com.suromo.liuwan.R
import com.suromo.liuwan.databinding.FragmentFollowBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/30
 * desc  : TODO
 */
class FollowFragment : BaseVMFragment<FragmentFollowBinding>(R.layout.fragment_follow)  {

    companion object {
        fun newInstance(): FollowFragment {
            return FollowFragment()
        }
    }

    override fun initView() {
        binding.followTv.text = "你好"
    }

    override fun initData() {

    }

    override fun startObserve() {

    }

}