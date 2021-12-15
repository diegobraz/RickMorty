package kanda.lab.domain.state

sealed class UiState<out T> {
    object Start : UiState<Nothing>()

    data class Success<out T>(val value: T) : UiState<T>()

    data class Failure(val exception: Throwable? = null) : UiState<Nothing>()

    object Finish : UiState<Nothing>()
}
