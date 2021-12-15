package kanda.lab.domain.state

internal class BypassErrorTransformer : StateMachineErrorTransformer {

    override fun apply(exception: Throwable): Throwable = exception
}
