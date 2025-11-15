package com.nexxlabs.lynq.core

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Failure(val code: Int, val message: String?) : NetworkResult<Nothing>()
    data class Exception(val exception: kotlin.Exception) : NetworkResult<Nothing>()
}