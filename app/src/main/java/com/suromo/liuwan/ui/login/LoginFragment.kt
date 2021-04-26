package com.suromo.liuwan.ui.login

import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.suromo.core.base.BaseVMFragment
import com.suromo.liuwan.R
import com.suromo.liuwan.databinding.FragmentLoginBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : 登录界面
 */
class LoginFragment : BaseVMFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private val loginViewModel by viewModel<LoginViewModel>()

    override fun initView() {
        setHasOptionsMenu(true)
        binding.run {

//            title =  Title(R.string.login, R.drawable.arrow_back) { onBackPressed() }
        }
    }

    override fun initData() {

    }

    @ExperimentalCoroutinesApi
    override fun startObserve() {
//        loginViewModel.apply {
//
//            uiState.observe(this@LoginFragment, Observer {
////                if (it.isLoading) showProgressDialog()
//
//                it.isSuccess?.let {
////                    dismissProgressDialog()
////                    finish()
//                }
//
//                it.isError?.let { err ->
////                    dismissProgressDialog()
////                    toast(err)
//                }
//
//                if (it.needLogin) loginViewModel.login()
//            })
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            findNavController().popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

}