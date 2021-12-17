package kanda.lab.feature.home.repository

import kanda.lab.domain.Character
import kanda.lab.domain.CharactersResponse
import kanda.lab.feature.home.api.CharacterApi
import kanda.lab.feature.home.network.ErrorResponse
import kanda.lab.feature.home.network.NetworkResponse
import kanda.lab.feature.home.repository.dataSource.CharacterDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class CharacterImpl @Inject constructor(
    private val characterApi: CharacterApi
):CharacterDataSource{
    override suspend fun getCharacter(
        dispatcher: CoroutineDispatcher,
        resultCallback: (result: NetworkResponse<List<Character>, ErrorResponse>) -> Unit
    ) {
        withContext(dispatcher){
            val showCharacter = async {
                characterApi.getAllCharacter(1)
            }
            processData(resultCallback, showCharacter.await())
        }
    }

    private fun processData(
        resultCallback: (result: NetworkResponse<List<Character>, ErrorResponse>)
        -> Unit, await: NetworkResponse<CharactersResponse, ErrorResponse>
    ) {
        val pair = buildResponse(await)
        if (pair.first == null) {
            pair.second?.let { resultCallback(it) }
        } else {
            resultCallback(NetworkResponse.Success(pair.first!!))
        }
    }

    private fun buildResponse(await: NetworkResponse<CharactersResponse, ErrorResponse>):
            Pair<List<Character>?, NetworkResponse<List<Character>, ErrorResponse>?> {

        return when (await) {
            is NetworkResponse.Success -> {
                Pair(await.body.results, null)
            }
            is NetworkResponse.ApiErro -> {
                Pair(null, NetworkResponse.ApiErro(await.body, await.code))
            }
            is NetworkResponse.Unknown -> {
                Pair(null, NetworkResponse.Unknown(Throwable()))
            }
            is NetworkResponse.Error -> {
                Pair(null, NetworkResponse.Error(IOException()))
            }
        }
    }
}