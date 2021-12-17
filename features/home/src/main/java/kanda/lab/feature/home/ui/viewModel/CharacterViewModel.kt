package kanda.lab.feature.home.ui.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kanda.lab.domain.Character
import kanda.lab.feature.home.api.CharacterApi
import kanda.lab.feature.home.di.IoDispatcher
import kanda.lab.feature.home.network.NetworkResponse
import kanda.lab.feature.home.paging.RickMortyPagingSource
import kanda.lab.feature.home.repository.dataSource.CharacterDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.DIAware
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterDataSource: CharacterDataSource,
    private val characterApi: CharacterApi,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : ViewModel(){
    private var _listCharacteres : MutableLiveData<List<Character>> = MutableLiveData()
    val listOfCharacter: LiveData<List<Character>> = _listCharacteres
    val listData  = Pager(PagingConfig(pageSize = 1)){
        RickMortyPagingSource(characterApi,dispatcher)
    }.flow.cachedIn(viewModelScope)

    fun loadCharacter() {
        viewModelScope.launch(dispatcher) {
            characterDataSource.getCharacter(dispatcher){ result ->
                when(result){
                    is NetworkResponse.Success -> {
                        Log.d("diego", result.body.toString())
                        _listCharacteres.postValue(result.body)
                    }
                    is NetworkResponse.Error ->{
                        Log.d("diego", "erro")
                    }
                    is NetworkResponse.ApiErro ->{
                        Log.d("diego", "erro")
                    }
                    else -> {
                        Log.d("diego", "erro")
                    }
                }
            }
        }
    }
}