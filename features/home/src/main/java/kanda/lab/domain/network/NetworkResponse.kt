package kanda.lab.domain.network

import java.io.IOException

sealed class NetworkResponse<out T : Any, out U : Any> {
    data class Success<T : Any>(val body: T) : NetworkResponse<T, Nothing>()

    data class Error<T : Any>(val erro: IOException) : NetworkResponse<T, Nothing>()

    data class Unknown<T : Any>(val erro: Throwable? = null) : NetworkResponse<T, Nothing>()

    data class ApiError<U : Any>(val body: U, val code: Int) : NetworkResponse<Nothing, U>()
}