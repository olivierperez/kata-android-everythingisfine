package fr.o80.everythingisfine.data

import fr.o80.everythingisfine.data.model.LocalPokemon

interface PokemonRepository {
    fun getPokemons(): List<LocalPokemon>
}
