package kanda.lab.feature.home.api

import kanda.lab.domain.CharactersResponse
import kanda.lab.feature.home.network.ErrorResponse
import kanda.lab.feature.home.network.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {
    @GET("character")
   suspend fun getAllCharacter(@Query("page") index: Int): NetworkResponse<CharactersResponse, ErrorResponse>
}