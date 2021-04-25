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
import fr.o80.everythingisfine.util.EventLiveData
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getPokemons: GetPokemons,
    private val getPokedex: GetPokedex,
    private val addPokemonToPokedex: AddPokemonToPokedex,
    private val freePokemon: FreePokemon
) : ViewModel() {

    private val _pokemons = MutableLiveData<Pair<List<Pokemon>, Set<Int>>>()
    val pokemons: LiveData<Pair<List<Pokemon>, Set<Int>>>
        get() = _pokemons

    private val _events = EventLiveData<Event>()
    val events: LiveData<Event>
        get() = _events

    init {
        _pokemons.postValue(Pair(getPokemons(-1), getPokedex()))
    }

    fun onPokeballClicked(pokemon: Pokemon) {
        if (getPokedex().contains(pokemon.id)) {
            freePokemon(pokemon)
        } else {
            addPokemonToPokedex(pokemon)
        }

        _pokemons.postValue(Pair(getPokemons(-1), getPokedex()))
    }

    fun onPokemonClicked(pokemon: Pokemon) {
        _events.postValue(Event.GoToDetails(pokemon))
    }

    sealed class Event {
        class GoToDetails(val pokemon: Pokemon) : Event()
    }
}
