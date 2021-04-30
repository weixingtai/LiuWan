package com.suromo.liuwan.ui.discovery

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
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

    private val mTypeList = mutableListOf("遛弯","关注","我的")
    private var mFragmentList: MutableList<Fragment> = mutableListOf()


    override fun initView() {
        setHasOptionsMenu(true)
        initViewPager()

        val mSet = AutoTransition()
        mSet.duration = 300


        binding.discoverySv.setOnSearchClickListener {
            TransitionManager.beginDelayedTransition(binding.discoverySv, mSet)
        }
    }

    override fun initData() {
        mFragmentList.add(WalkFragment.newInstance())
        mFragmentList.add(FollowFragment.newInstance())
        mFragmentList.add(MineFragment.newInstance())
    }

    override fun startObserve() {

    }

    private fun initViewPager(){
        binding.discoveryVp.adapter = object :FragmentStateAdapter(this){

            override fun getItemCount() = mTypeList.size

            override fun createFragment(position: Int): Fragment {
                return mFragmentList[position]
            }
        }

        TabLayoutMediator(binding.discoveryTl,binding.discoveryVp){ tab, position ->
            tab.text = mTypeList[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_login_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}