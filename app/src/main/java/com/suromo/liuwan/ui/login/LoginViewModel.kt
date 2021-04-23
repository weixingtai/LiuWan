package com.suromo.liuwan.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.suromo.core.base.BaseViewModel
import com.suromo.liuwan.data.model.LoginUIState
import com.suromo.liuwan.data.model.User
import com.suromo.liuwan.data.repo.LoginRepository
import com.suromo.liuwan.provider.CoroutinesDispatcherProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
class LoginViewModel(val repository: LoginRepository, val provider: CoroutinesDispatcherProvider) : BaseViewModel() {

    val userName = ObservableField("")
    val passWord = ObservableField("")

    private val _uiState = MutableLiveData<LoginUIState<User>>()
    val uiState: LiveData<LoginUIState<User>>
        get() = _uiState

    private fun isInputValid(userName: String, passWord: String) = userName.isNotBlank() && passWord.isNotBlank()

    fun loginDataChanged() {
        _uiState.value = LoginUIState(enableLoginButton = isInputValid(userName.get()
            ?: "", passWord.get() ?: ""))
    }

    @ExperimentalCoroutinesApi
    fun login() {
        launchOnUI {
            // repo 返回的是一个 flow
            repository.loginFlow(userName.get() ?: "", passWord.get() ?: "")
                .collect { _uiState.postValue(it) }

        }
    }

    @ExperimentalCoroutinesApi
    fun register() {
        launchOnUI {
            repository.registerFlow(userName.get() ?: "", passWord.get() ?: "")
                .collect {
                    _uiState.postValue(it)
                }
        }
    }

    val verifyInput: (String) -> Unit = { loginDataChanged() }
}