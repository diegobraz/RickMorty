package kanda.lab.domain.remote

import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

internal class DefaultErrorTransform : NetworkErrorTransform {

    override fun transform(error: Throwable) = when (error) {
        is SocketTimeoutException,
        is UnknownHostException,
        is ConnectException -> ConnectionException(error)
        else -> InternalError(error)
    }
}
