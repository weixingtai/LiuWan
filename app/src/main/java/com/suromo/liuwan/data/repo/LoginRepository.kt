package com.suromo.liuwan.data.repo

import com.google.gson.Gson
import com.suromo.liuwan.App
import com.suromo.liuwan.data.model.LoginUIState
import com.suromo.liuwan.data.model.User
import com.suromo.liuwan.data.model.doError
import com.suromo.liuwan.data.model.doSuccess
import com.suromo.liuwan.data.network.ApiService
import com.suromo.liuwan.data.network.BaseRepository
import com.suromo.liuwan.utils.Preference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
class LoginRepository(val service: ApiService) : BaseRepository() {

    private var isLogin by Preference(Preference.IS_LOGIN, false)
    private var userJson by Preference(Preference.USER_GSON, "")

    @ExperimentalCoroutinesApi
    suspend fun loginFlow(userName: String, passWord: String) = flow {

        // 输入不能为空
        if (userName.isBlank() || passWord.isBlank()) {
            emit(LoginUIState(enableLoginButton = false))
            return@flow
        }

        service.login(userName, passWord).doSuccess { user ->
            isLogin = true
            userJson = Gson().toJson(user)
            App.CURRENT_USER = user
            emit(LoginUIState(isSuccess = user, enableLoginButton = true))
        }.doError { errorMsg ->
            emit(LoginUIState<User>(isError = errorMsg, enableLoginButton = true))
        }
    }.onStart {
        emit(LoginUIState(isLoading = true))
    }.flowOn(Dispatchers.IO)
        .catch { emit(LoginUIState(isError = it.message, enableLoginButton = true)) }


    @ExperimentalCoroutinesApi
    suspend fun registerFlow(userName: String, passWord: String) = flow<LoginUIState<User>> {

        // 输入不能为空
        if (userName.isBlank() || passWord.isBlank()) {
            emit(LoginUIState(enableLoginButton = false))
            return@flow
        }

        service.register(userName, passWord, passWord).doSuccess {
            emit(LoginUIState(needLogin = true))
        }.doError { errorMsg ->
            emit(LoginUIState(isError = errorMsg, enableLoginButton = true))
        }
    }.onStart {
        emit(LoginUIState(isLoading = true))
    }.flowOn(Dispatchers.IO)
        .catch { emit(LoginUIState(isError = it.message, enableLoginButton = true)) }

}