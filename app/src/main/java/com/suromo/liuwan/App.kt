package com.suromo.liuwan

import android.app.Application
import android.content.Context
import com.orhanobut.hawk.Hawk
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.suromo.liuwan.data.model.User
import com.suromo.liuwan.di.appModule
import luyao.mvvm.core.util.Timer
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import kotlin.properties.Delegates

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : Application实现类
 */
class App : Application() {
    companion object {
        var CONTEXT: Context by Delegates.notNull()
        lateinit var CURRENT_USER: User
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Timer.start("app start")
    }

    override fun onCreate() {
        super.onCreate()

        CONTEXT = applicationContext

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }

        Hawk.init(CONTEXT).build()

        Logger.addLogAdapter(AndroidLogAdapter())


    }
}