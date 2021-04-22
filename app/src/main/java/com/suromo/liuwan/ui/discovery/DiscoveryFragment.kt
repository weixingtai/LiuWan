package com.suromo.liuwan.ui.discovery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.suromo.liuwan.databinding.FragmentDiscoveryBinding
import com.suromo.liuwan.databinding.FragmentUserBinding
import com.suromo.liuwan.ui.user.UserViewModel

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
class DiscoveryFragment : Fragment() {

    private lateinit var discoveryViewModel: DiscoveryViewModel
    private var _binding: FragmentDiscoveryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        discoveryViewModel =
            ViewModelProvider(this).get(DiscoveryViewModel::class.java)

        _binding = FragmentDiscoveryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.discoveryTv
        discoveryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}