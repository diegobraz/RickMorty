package kanda.lab.feature.home.repository.imp

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kanda.lab.domain.Character
import kanda.lab.domain.CharactersResponse
import kanda.lab.feature.home.api.CharacterApiService
import kanda.lab.feature.home.network.ErrorResponse
import kanda.lab.feature.home.network.NetworkResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class RickMortyPagingImpl(
    private val apiService: CharacterApiService,
    private val dispatcher: CoroutineDispatcher
) : PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return withContext(dispatcher){
            val currentPage = params.key ?: 1
            val response = async { apiService.getAllCharacter(currentPage) }
            val data = processData(response.await())
            val responseData = mutableListOf<Character>()
            responseData.addAll(data)
            LoadResult.Page(
                data = responseData,
                prevKey = if(currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        }
    }

    private fun processData(await: NetworkResponse<CharactersResponse, ErrorResponse>): List<Character> {
        return when(await){
            is NetworkResponse.Success ->{
                await.body.results
            }
            else -> {
                emptyList()
            }
        }
    }
}