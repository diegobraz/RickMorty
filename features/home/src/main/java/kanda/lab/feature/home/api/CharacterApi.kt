package kanda.lab.feature.home.api

import kanda.lab.domain.CharactersResponse
import kanda.lab.feature.home.network.ErrorResponse
import kanda.lab.feature.home.network.NetworkResponse
import retrofit2.http.GET

interface CharacterApi {
    @GET("character")
   suspend fun getAllCharacter(): NetworkResponse<CharactersResponse, ErrorResponse>
}