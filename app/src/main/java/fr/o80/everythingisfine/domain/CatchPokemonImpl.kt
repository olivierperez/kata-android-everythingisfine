package fr.o80.everythingisfine.domain

import dagger.hilt.android.scopes.ViewModelScoped
import fr.o80.everythingisfine.data.PokedexRepository
import javax.inject.Inject

@ViewModelScoped
class CatchPokemonImpl @Inject constructor(
    private val pokedexRepository: PokedexRepository
) : CatchPokemon {
    override operator fun invoke(pokemonId: Int) {
        pokedexRepository.addPokemon(pokemonId)
    }
}
