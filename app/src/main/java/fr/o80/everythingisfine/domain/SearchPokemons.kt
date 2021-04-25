package fr.o80.everythingisfine.domain

import dagger.hilt.android.scopes.ViewModelScoped
import fr.o80.everythingisfine.data.PokemonRepository
import fr.o80.everythingisfine.data.model.Pokemon
import javax.inject.Inject

@ViewModelScoped
class SearchPokemons @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    operator fun invoke(search: String): List<Pokemon> {
        return pokemonRepository.getPokemons()
            .filter { pokemon -> pokemon.name.contains(search, ignoreCase = true) }
    }

    fun match(pokemon: Pokemon, name: String) : Boolean {
        return pokemon.name.startsWith(name)
    }
}
