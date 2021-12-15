package kanda.lab.domain.remote

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext

internal class DefaultNetworkManager(
    private val connectionCheck: ConnectionCheck,
    private val mapper: NetworkErrorTransform = DefaultErrorTransform()
) : ApiRequest {

    override suspend fun <T> performRequest(
        dispatcher: CoroutineDispatcher,
        action: suspend () -> T
    ): T = supervisorScope {
        if (connectionCheck.hasConnection().not()) throw ConnectionUnavailable
        withContext(dispatcher) {
            runCatching { action() }
                .getOrElse { error ->
                    error.printStackTrace()
                    throw mapper.transform(error)
                }
        }
    }
}
