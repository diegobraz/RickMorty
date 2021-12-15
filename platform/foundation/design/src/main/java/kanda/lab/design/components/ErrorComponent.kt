package kanda.lab.design.components

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kanda.lab.design.views.GenericErrorItem
import kanda.lab.design.views.NoConnectionItem
import kanda.lab.domain.remote.ConnectionUnavailable
import kanda.lab.domain.state.UiState
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ErrorComponent(
    private val uiState: SharedFlow<UiState<*>>,
    private val onRetry: () -> Unit,
    private val view: RecyclerView,
    scope: LifecycleCoroutineScope
) {

    private val adapter by lazy { GroupAdapter<GroupieViewHolder>() }

    init {
        scope.launch {
            uiState.collect { state ->

                if (state is UiState.Failure) {
                    adapter.clear()
                    view.adapter = adapter
                    state.exception.setupErrorItem()
                }
            }
        }
    }

    private fun Throwable?.setupErrorItem() {
        this?.printStackTrace()
        val item = when (this is ConnectionUnavailable) {
            true -> NoConnectionItem(onRetry)
            false -> GenericErrorItem(onRetry)
        }
        adapter.add(item)
    }
}
