package kanda.lab.domain.test

import kanda.lab.domain.remote.ApiRequest
import kanda.lab.domain.remote.ConnectionUnavailable
import kanda.lab.domain.remote.DefaultNetworkManager
import kanda.lab.fake.ConnectionCheckFake
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

internal class NetworkManagerTest {

    private lateinit var manager: ApiRequest

    @Before
    fun `before each test`() {
        ConnectionCheckFake.hasConnection = true
        manager = DefaultNetworkManager(ConnectionCheckFake)
    }

    @Test(expected = ConnectionUnavailable::class)
    fun `when without connection should throw a ConnectionUnavailable`() {
        ConnectionCheckFake.hasConnection = false
        runBlocking {
            manager.performRequest {
                // no op
            }
        }
    }

    @Test
    fun `when with connection should emmit an result`() {
        ConnectionCheckFake.hasConnection = true
        val emmit = "just a simple result"
        runBlocking {
            val result = manager.performRequest {
                emmit
            }
            assertThat(result).isEqualTo(emmit)
        }
    }
}
