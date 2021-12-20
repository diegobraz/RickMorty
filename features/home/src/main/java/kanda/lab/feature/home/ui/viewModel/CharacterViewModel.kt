package kanda.lab.feature.home.ui.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kanda.lab.feature.home.api.CharacterApiService
import kanda.lab.domain.di.IoDispatcher
import kanda.lab.feature.home.repository.CharacterPagingImpl
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterApiService: CharacterApiService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : ViewModel(){
    val listData  = Pager(PagingConfig(pageSize = 1)){
        CharacterPagingImpl(characterApiService,dispatcher)
    }.flow.cachedIn(viewModelScope)
}