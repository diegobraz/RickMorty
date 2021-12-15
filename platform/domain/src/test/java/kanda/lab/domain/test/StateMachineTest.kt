package kanda.lab.domain.test

import app.cash.turbine.test
import junit.framework.Assert.assertEquals
import kanda.lab.domain.remote.ConnectionUnavailable
import kanda.lab.domain.state.UiState
import kanda.lab.domain.state.stateMachine
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.time.ExperimentalTime

internal class StateMachineTest {

    @ExperimentalTime
    @Test
    fun `should emmit states without error`() = runBlocking {
        val emmit = "A simple value"
        stateMachine { emmit }
            .test {
                assertEquals(UiState.Start, expectItem())
                assertEquals(UiState.Success(emmit), expectItem())
                assertEquals(UiState.Finish, expectItem())
                expectComplete()
            }
    }

    @ExperimentalTime
    @Test
    fun `should emmit states with error`() = runBlocking {
        val error = ConnectionUnavailable
        stateMachine { throw error }
            .test {
                assertEquals(UiState.Start, expectItem())
                assertEquals(UiState.Failure(error), expectItem())
                assertEquals(UiState.Finish, expectItem())
                expectComplete()
            }
    }
}
