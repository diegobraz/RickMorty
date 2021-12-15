package kanda.lab.domain.state

interface StateMachineErrorTransformer {

    fun apply(exception: Throwable): Throwable
}
