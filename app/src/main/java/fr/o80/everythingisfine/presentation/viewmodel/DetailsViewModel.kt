package fr.o80.everythingisfine.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.o80.everythingisfine.domain.CatchPokemon
import fr.o80.everythingisfine.domain.FreePokemon
import fr.o80.everythingisfine.domain.GetPokemons
import fr.o80.everythingisfine.domain.model.Pokemon
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getPokemons: GetPokemons,
    private val catchPokemon: CatchPokemon,
    private val freePokemon: FreePokemon
) : ViewModel() {

    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon>
        get() = _pokemon

    fun init(pokemonId: Int) {
        val pokemon = getPokemons().first { it.id == pokemonId }
        _pokemon.postValue(pokemon)
    }

    fun onPokeballClicked(shouldFreePokemon: Boolean) {
        val pokemon = pokemon.value!!
        pokemon.isAttrapped = !shouldFreePokemon
        val togglePokemon = if (shouldFreePokemon) {
            freePokemon::invoke
        } else {
            catchPokemon::invoke
        }
        togglePokemon(pokemon.id)
        _pokemon.postValue(pokemon)
    }
}
