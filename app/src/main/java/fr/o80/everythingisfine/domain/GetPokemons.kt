package fr.o80.everythingisfine.domain

import dagger.hilt.android.scopes.ViewModelScoped
import fr.o80.everythingisfine.data.PokedexRepository
import fr.o80.everythingisfine.data.PokemonRepository
import fr.o80.everythingisfine.data.model.LocalPokemon
import fr.o80.everythingisfine.domain.model.Pokemon
import javax.inject.Inject

@ViewModelScoped
class GetPokemons @Inject constructor(
    private val pokemonRepo: PokemonRepository,
    private val pokedexRepo: PokedexRepository,
) {
    operator fun invoke(): List<Pokemon> {
        return pokemonRepo.getPokemons().map { localPokemon: LocalPokemon ->
            val isAttrapped = pokedexRepo.getPokedex().contains(localPokemon.id)

            Pokemon(
                id = localPokemon.id,
                name = localPokemon.name,
                hp = localPokemon.base.hp,
                attack = localPokemon.base.attack,
                defense = localPokemon.base.defense,
                isAttrapped = isAttrapped
            )
        }
    }
}
