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
import com.suromo.liuwan.data.model.Banner
import com.suromo.liuwan.data.model.Recommend
import com.suromo.liuwan.databinding.FragmentHomeBinding
import com.youth.banner.indicator.CircleIndicator

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : 找车界面（首页）
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

        val bean1 = Banner(R.drawable.ic_banner_demo1,"标题")
        val bean2 = Banner(R.drawable.ic_banner_demo2,"qq")
        val list: MutableList<Banner> = ArrayList()
        list.add(bean1)
        list.add(bean2)
        binding.homeBanner.addBannerLifecycleObserver(this)
            .setAdapter(HomeBannerAdapter(list)).indicator = CircleIndicator(context)

        val bean3 = Recommend(R.drawable.ic_banner_demo1,R.drawable.ic_qq,"菲亚特500","丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非常牛逼",5.3)
        val bean4 = Recommend(R.drawable.ic_banner_demo2,R.drawable.ic_qq,"奔驰ML400","丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非",10.4)
        val bean5 = Recommend(R.drawable.ic_banner_demo2,R.drawable.ic_qq,"奔驰ML500","丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非纪念版非常牛逼非",60.4)
        val bean6 = Recommend(R.drawable.ic_banner_demo1,R.drawable.ic_qq,"奔驰ML700","丰田纪念版非常牛逼非常牛逼丰田纪念版非常牛逼非常牛逼丰田牛逼非",70.4)
        val recommendList: MutableList<Recommend> = ArrayList()
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