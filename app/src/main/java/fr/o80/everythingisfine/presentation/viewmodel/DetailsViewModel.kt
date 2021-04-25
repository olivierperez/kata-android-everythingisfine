package fr.o80.everythingisfine.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.o80.everythingisfine.data.model.Pokemon
import fr.o80.everythingisfine.domain.AddPokemonToPokedex
import fr.o80.everythingisfine.domain.FreePokemon
import fr.o80.everythingisfine.domain.GetPokedex
import fr.o80.everythingisfine.domain.GetPokemons
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getPokemons: GetPokemons,
    private val getPokedex: GetPokedex,
    private val addPokemonToPokedex: AddPokemonToPokedex,
    private val freePokemon: FreePokemon
) : ViewModel() {

    private val _pokemon = MutableLiveData<Pair<Pokemon, Boolean>>()
    val pokemon: LiveData<Pair<Pokemon, Boolean>>
        get() = _pokemon

    fun init(pokemonId: Int) {
        val pokemon = getPokemons(-1).first { it.id == pokemonId }
        val isInPokedex = getPokedex().contains(pokemonId)
        _pokemon.postValue(Pair(pokemon, isInPokedex))
    }

    fun onPokeballClicked(shouldFreePokemon: Boolean) {
        val (pokemon, _) = pokemon.value!!
        val togglePokemon =
            if (shouldFreePokemon) freePokemon::invoke
            else addPokemonToPokedex::invoke
        togglePokemon(pokemon)
        _pokemon.postValue(Pair(pokemon, !shouldFreePokemon))
    }
}
