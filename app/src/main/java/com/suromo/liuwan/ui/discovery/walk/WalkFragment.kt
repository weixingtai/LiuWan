package com.suromo.liuwan.ui.discovery.walk

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.suromo.core.base.BaseVMFragment
import com.suromo.liuwan.R
import com.suromo.liuwan.data.model.Article
import com.suromo.liuwan.data.model.Banner
import com.suromo.liuwan.data.model.Recommend
import com.suromo.liuwan.databinding.FragmentWalkBinding
import com.suromo.liuwan.ui.home.HomeBannerAdapter
import com.suromo.liuwan.ui.home.HomeRecommendAdapter
import com.youth.banner.indicator.CircleIndicator

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/30
 * desc  : TODO
 */
class WalkFragment : BaseVMFragment<FragmentWalkBinding>(R.layout.fragment_walk)  {

    companion object {
        fun newInstance(): WalkFragment {
            return WalkFragment()
        }
    }

    override fun initView() {

        var imgList: MutableList<String> = mutableListOf("","")

        val bean1 = Article(1,"111","Samuel","2021-05-06","深圳400带你走向人生巅峰",
            "年前的那个夜晚，我和几个朋友年前的狂欢，一阵大醉，迷迷糊糊中，心念一动，想到了楼上衣服还没收，突然后悔莫及，此块，以快马加鞭，马不停蹄的赶回家，" +
                    "边走边拨打着隔壁亚朵服务热线。",imgList,like = true,share = true,collect = true,3,6,"遛弯的萨拉：好看",1)
        val bean2 = Article(1,"111","Samuel","2021-05-06","深圳400带你走向人生巅峰",
            "年前的那个夜晚，我和几个朋友年前的狂欢，一阵大醉，迷迷糊糊中，心念一动，想到了楼上衣服还没收，突然后悔莫及，此块，以快马加鞭，马不停蹄的赶回家，" +
                    "边走边拨打着隔壁亚朵服务热线。",imgList,like = true,share = true,collect = true,3,6,"遛弯的萨拉：好看",1)
        val bean3 = Article(1,"111","Samuel","2021-05-06","深圳400带你走向人生巅峰",
            "年前的那个夜晚，我和几个朋友年前的狂欢，一阵大醉，迷迷糊糊中，心念一动，想到了楼上衣服还没收，突然后悔莫及，此块，以快马加鞭，马不停蹄的赶回家，" +
                    "边走边拨打着隔壁亚朵服务热线。",imgList,like = true,share = true,collect = true,3,6,"遛弯的萨拉：好看",1)
        val bean4 = Article(1,"111","Samuel","2021-05-06","深圳400带你走向人生巅峰",
            "年前的那个夜晚，我和几个朋友年前的狂欢，一阵大醉，迷迷糊糊中，心念一动，想到了楼上衣服还没收，突然后悔莫及，此块，以快马加鞭，马不停蹄的赶回家，" +
                    "边走边拨打着隔壁亚朵服务热线。",imgList,like = true,share = true,collect = true,3,6,"遛弯的萨拉：好看",1)
        val articleList: MutableList<Article> = ArrayList()
        articleList.add(bean1)
        articleList.add(bean2)
        articleList.add(bean3)
        articleList.add(bean4)

        binding.walkRcyArticle.layoutManager = LinearLayoutManager(context)
        binding.walkRcyArticle.itemAnimator = DefaultItemAnimator()
        binding.walkRcyArticle.adapter = WalkAdapter(articleList)
    }

    override fun initData() {

    }

    override fun startObserve() {

    }

}