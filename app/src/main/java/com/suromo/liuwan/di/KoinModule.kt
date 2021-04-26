package com.suromo.liuwan.di

import com.suromo.liuwan.data.network.ApiService
import com.suromo.liuwan.data.network.RetrofitClient
import com.suromo.liuwan.data.repo.LoginRepository
import com.suromo.liuwan.provider.CoroutinesDispatcherProvider
import com.suromo.liuwan.ui.discovery.DiscoveryViewModel
import com.suromo.liuwan.ui.login.LoginViewModel
import com.suromo.liuwan.ui.notifications.NotificationsViewModel
import com.suromo.liuwan.ui.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
val viewModelModule = module {
    viewModel { LoginViewModel(get(),get()) }
//    viewModel { ArticleViewModel(get(), get(), get(), get(), get()) }
//    viewModel { SystemViewModel(get(), get()) }
//    viewModel { NavigationViewModel(get()) }
    viewModel { DiscoveryViewModel() }
    viewModel { NotificationsViewModel() }
    viewModel { UserViewModel() }
}

val repositoryModule = module {
    single { RetrofitClient.getService(ApiService::class.java, ApiService.BASE_URL) }
    single { CoroutinesDispatcherProvider() }
    single { LoginRepository(get()) }
//    single { SquareRepository() }
//    single { HomeRepository() }
//    single { ProjectRepository() }
//    single { CollectRepository() }
//    single { SystemRepository() }
//    single { NavigationRepository() }
//    single { SearchRepository() }
//    single { ShareRepository() }
}

val appModule = listOf(viewModelModule, repositoryModule)