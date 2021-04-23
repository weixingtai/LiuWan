package com.suromo.liuwan

import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.suromo.core.base.BaseVMActivity
import com.suromo.liuwan.databinding.ActivityMainBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
class MainActivity : BaseVMActivity() {

    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)

    override fun initView() {

        val mainBnv: BottomNavigationView = binding.mainBnv
        val navController = findNavController(R.id.main_nhf)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_discovery, R.id.nav_notifications, R.id.nav_user
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        mainBnv.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.nav_home || destination.id == R.id.nav_discovery
                ||destination.id == R.id.nav_notifications ||destination.id == R.id.nav_user){
                mainBnv.visibility = View.VISIBLE
            }else{
                mainBnv.visibility = View.GONE
            }
        }
    }

    override fun initData() {

    }

    override fun startObserve() {

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}