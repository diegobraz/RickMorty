package kanda.lab.domain.state

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

fun <T> stateMachine(
    dispatcher: CoroutineDispatcher = Dispatchers.Default,
    errorTransformer: StateMachineErrorTransformer = BypassErrorTransformer(),
    action: suspend () -> T
): Flow<UiState<T>> =
    flow<UiState<T>> { emit(UiState.Success(action())) }
        .catch { exception -> emit(UiState.Failure(errorTransformer.apply(exception))) }
        .onStart { emit(UiState.Start) }
        .onCompletion { emit(UiState.Finish) }
        .flowOn(dispatcher)
