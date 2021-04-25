package fr.o80.everythingisfine.domain

import dagger.hilt.android.scopes.ViewModelScoped
import fr.o80.everythingisfine.data.PokemonRepository
import fr.o80.everythingisfine.data.model.Pokemon
import javax.inject.Inject

@ViewModelScoped
class GetPokemons @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(limit: Int): List<Pokemon> {
        return repository.getPokemons()
    }
}
