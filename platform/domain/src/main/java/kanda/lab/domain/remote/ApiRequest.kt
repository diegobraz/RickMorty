package kanda.lab.domain.remote

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface ApiRequest {

    @Throws(ConnectionUnavailable::class)
    suspend fun <T> performRequest(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        action: suspend () -> T
    ): T
}
