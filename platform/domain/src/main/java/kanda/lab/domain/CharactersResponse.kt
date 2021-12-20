package kanda.lab.domain

data class CharactersResponse(
    val info: Info,
    val results: List<Character>
)