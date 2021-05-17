package fr.o80.everythingisfine.domain

import dagger.hilt.android.scopes.ViewModelScoped
import fr.o80.everythingisfine.data.PokedexRepository
import javax.inject.Inject

@ViewModelScoped
class FreePokemon @Inject constructor(
    private val pokedexRepository: PokedexRepository
) {
    operator fun invoke(pokemonId: Int) {
        pokedexRepository.removePokemon(pokemonId)
    }
}
