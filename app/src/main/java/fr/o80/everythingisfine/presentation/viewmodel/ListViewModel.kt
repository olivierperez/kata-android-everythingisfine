package fr.o80.everythingisfine.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.o80.everythingisfine.domain.CatchPokemon
import fr.o80.everythingisfine.domain.FreePokemon
import fr.o80.everythingisfine.domain.GetPokemons
import fr.o80.everythingisfine.domain.model.Pokemon
import fr.o80.everythingisfine.presentation.util.EventLiveData
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getPokemons: GetPokemons,
    private val catchPokemon: CatchPokemon,
    private val freePokemon: FreePokemon
) : ViewModel() {

    private val _pokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>>
        get() = _pokemons

    private val _events = EventLiveData<Event>()
    val events: LiveData<Event>
        get() = _events

    fun start() {
        _pokemons.postValue(getPokemons())
    }

    fun onPokeballClicked(pokemon: Pokemon) {
        if (pokemon.isAttrapped) {
            freePokemon(pokemon.id)
        } else {
            catchPokemon(pokemon.id)
        }

        _pokemons.postValue(getPokemons())
    }

    fun onPokemonClicked(pokemon: Pokemon) {
        _events.postValue(Event.GoToDetails(pokemon))
    }

    sealed class Event {
        class GoToDetails(val pokemon: Pokemon) : Event()
    }
}
