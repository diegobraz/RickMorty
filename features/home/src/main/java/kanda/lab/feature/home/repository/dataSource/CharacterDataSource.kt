package kanda.lab.feature.home.repository.dataSource

import kanda.lab.domain.Character
import kanda.lab.feature.home.network.ErrorResponse
import kanda.lab.feature.home.network.NetworkResponse
import kotlinx.coroutines.CoroutineDispatcher

interface CharacterDataSource {
    suspend fun getCharacter(
      dispatcher: CoroutineDispatcher,
      resultCallback:(result:NetworkResponse<List<Character>,ErrorResponse>) -> Unit
    )
}