package kanda.lab.domain.remote

interface NetworkErrorTransform {

    fun transform(error: Throwable): Throwable
}
