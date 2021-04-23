package com.suromo.liuwan.data.model

import com.suromo.core.base.BaseViewModel

/**
 * Created by luyao
 * on 2020/3/30 15:34
 */
class LoginUIState<T>(
        isLoading: Boolean = false,
        isSuccess: T? = null,
        isError: String? = null,
        val enableLoginButton: Boolean = false,
        val needLogin: Boolean = false
) : BaseViewModel.UIState<T>(isLoading, false, isSuccess, isError)
