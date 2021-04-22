package com.suromo.liuwan.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.suromo.liuwan.R
import com.suromo.liuwan.data.home.BannerBean
import com.suromo.liuwan.data.home.RecommendBean
import com.suromo.liuwan.databinding.FragmentHomeBinding
import com.youth.banner.indicator.CircleIndicator

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val bean1 = BannerBean(R.drawable.ic_banner_demo1,"标题")
        val bean2 = BannerBean(R.drawable.ic_banner_demo2,"qq")
        val beanList: MutableList<BannerBean> = ArrayList()
        beanList.add(bean1)
        beanList.add(bean2)
        binding.homeBanner.addBannerLifecycleObserver(this)
            .setAdapter(HomeBannerAdapter(beanList)).indicator = CircleIndicator(context)

        val bean3 = RecommendBean(R.drawable.ic_banner_demo1,R.drawable.ic_qq,"菲亚特500","丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非常牛逼",5.3)
        val bean4 = RecommendBean(R.drawable.ic_banner_demo2,R.drawable.ic_qq,"奔驰ML400","丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非",10.4)
        val bean5 = RecommendBean(R.drawable.ic_banner_demo2,R.drawable.ic_qq,"奔驰ML500","丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非纪念版非常牛逼非",60.4)
        val bean6 = RecommendBean(R.drawable.ic_banner_demo1,R.drawable.ic_qq,"奔驰ML700","丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非常牛逼丰田牛逼非",70.4)
        val recommendList: MutableList<RecommendBean> = ArrayList()
        recommendList.add(bean3)
        recommendList.add(bean4)
        recommendList.add(bean5)
        recommendList.add(bean6)

        binding.homeRcvRecommend.layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
        binding.homeRcvRecommend.itemAnimator = DefaultItemAnimator()
        binding.homeRcvRecommend.adapter = HomeRecommendAdapter(recommendList)


        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_login_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId== R.id.menu_btn_login){
            findNavController().navigate(R.id.action_nav_home_to_nav_login)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}