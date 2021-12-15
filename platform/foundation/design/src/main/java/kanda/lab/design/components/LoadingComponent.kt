package kanda.lab.design.components

import android.view.View
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kanda.lab.domain.state.UiState
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoadingComponent(
    private val uiState: SharedFlow<UiState<*>>,
    private val view: View,
    scope: LifecycleCoroutineScope
) {
    init {
        scope.launch {
            uiState.collect { state -> state.setupLoading() }
        }
    }

    private fun UiState<*>.setupLoading() {
        val isLoading = this is UiState.Start

        if (view is SwipeRefreshLayout) {
            view.isRefreshing = isLoading
            return
        }
        view.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}
