package kanda.lab.feature.home.api

import kanda.lab.domain.CharactersResponse
import kanda.lab.domain.network.ErrorResponse
import kanda.lab.domain.network.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {
    @GET("character")
    suspend fun getAllCharacter(@Query("page") index: Int):
            NetworkResponse<CharactersResponse, ErrorResponse>
}