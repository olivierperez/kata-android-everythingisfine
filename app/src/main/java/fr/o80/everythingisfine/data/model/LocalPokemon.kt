package fr.o80.everythingisfine.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocalPokemon(
    val id: Int,
    val name: String,
    val base: LocalPokemonBase
)

@JsonClass(generateAdapter = true)
data class LocalPokemonBase(
    @Json(name = "HP")
    val hp: Int,
    @Json(name = "Attack")
    val attack: Int,
    @Json(name = "Defense")
    val defense: Int
)
