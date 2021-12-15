package kanda.lab.domain.remote

class ConnectionException(unMappedError: Throwable) : Throwable(unMappedError)
class InternalError(unMappedError: Throwable) : Throwable(unMappedError)
object ConnectionUnavailable : Throwable(message = "User has no connection")
