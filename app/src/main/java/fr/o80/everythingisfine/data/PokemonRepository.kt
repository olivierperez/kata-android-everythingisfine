package fr.o80.everythingisfine.data

import fr.o80.everythingisfine.data.model.Pokemon

interface PokemonRepository {
    fun getPokemons(): List<Pokemon>
}
