package fr.o80.everythingisfine.domain

import dagger.hilt.android.scopes.ViewModelScoped
import fr.o80.everythingisfine.domain.model.Pokemon
import javax.inject.Inject

@ViewModelScoped
class SearchPokemons @Inject constructor(
    private val getPokemons: GetPokemons
) {
    operator fun invoke(search: String): List<Pokemon> {
        return getPokemons()
            .filter { pokemon -> pokemon.name.contains(search, ignoreCase = true) }
    }
}
