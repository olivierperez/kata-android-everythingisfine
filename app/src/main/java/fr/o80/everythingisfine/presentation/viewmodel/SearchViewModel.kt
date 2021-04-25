package fr.o80.everythingisfine.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.o80.everythingisfine.data.model.Pokemon
import fr.o80.everythingisfine.domain.GetPokedex
import fr.o80.everythingisfine.domain.SearchPokemons
import fr.o80.everythingisfine.util.EventLiveData
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchPokemons: SearchPokemons,
    private val getPokedex: GetPokedex
) : ViewModel() {

    private val _pokemons = MutableLiveData<Pair<List<Pokemon>, Set<Int>>>()
    val pokemons: LiveData<Pair<List<Pokemon>, Set<Int>>>
        get() = _pokemons

    private val _events = EventLiveData<Event>()
    val events: LiveData<Event>
        get() = _events

    fun search(search: String) {
        val pokemons = searchPokemons(search)
        val pokedex = getPokedex()

        _pokemons.postValue(Pair(pokemons, pokedex))
    }

    fun onPokemonClicked(pokemon: Pokemon) {
        _events.postValue(Event.GoToDetails(pokemon))
    }

    fun onPokeballClicked(pokemon: Pokemon) {
        _events.postValue(Event.GoToDetails(pokemon))
    }

    sealed class Event {
        class GoToDetails(val pokemon: Pokemon) : Event()
    }
}