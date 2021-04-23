package com.suromo.liuwan.data.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import com.suromo.core.data.Result
import java.io.IOException

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/23
 * desc  : TODO
 */
data class Response<out T>(val errorCode: Int, val errorMsg: String, val data: T)

suspend fun <T : Any> Response<T>.executeResponse(successBlock: (suspend CoroutineScope.() -> Unit)? = null,
                                                     errorBlock: (suspend CoroutineScope.() -> Unit)? = null): Result<T> {
    return coroutineScope {
        if (errorCode == -1) {
            errorBlock?.let { it() }
            Result.Error(IOException(errorMsg))
        } else {
            successBlock?.let { it() }
            Result.Success(data)
        }
    }
}

suspend fun <T : Any> Response<T>.doSuccess(successBlock: (suspend CoroutineScope.(T) -> Unit)? = null): Response<T> {
    return coroutineScope {
        if (errorCode != -1) successBlock?.invoke(this, this@doSuccess.data)
        this@doSuccess
    }

}

suspend fun <T : Any> Response<T>.doError(errorBlock: (suspend CoroutineScope.(String) -> Unit)? = null): Response<T> {
    return coroutineScope {
        if (errorCode == -1) errorBlock?.invoke(this, this@doError.errorMsg)
        this@doError
    }
}
