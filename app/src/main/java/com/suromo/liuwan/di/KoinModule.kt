package com.suromo.liuwan.di

import org.koin.dsl.module

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
val viewModelModule = module {
//    viewModel { LoginViewModel(get(),get()) }
//    viewModel { ArticleViewModel(get(), get(), get(), get(), get()) }
//    viewModel { SystemViewModel(get(), get()) }
//    viewModel { NavigationViewModel(get()) }
//    viewModel { ProjectViewModel(get()) }
//    viewModel { SearchViewModel(get(), get()) }
//    viewModel { ShareViewModel(get()) }
}

val repositoryModule = module {
//    single { WanRetrofitClient.getService(WanService::class.java, WanService.BASE_URL) }
//    single { CoroutinesDispatcherProvider() }
//    single { LoginRepository(get()) }
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