package com.suromo.core.data

/**

\* author : weixingtai

\* e-mail : xingtai.wei@icloud.com

\* time  : 2021/4/22

\* desc  : TODO

 */
sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}