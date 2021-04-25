package fr.o80.everythingisfine.data

import javax.inject.Inject
import javax.inject.Singleton

import java.util.LinkedList

@Singleton
class InMemoryPokedexRepository @Inject constructor() : PokedexRepository {

    private var pokedex = mutableSetOf<Int>()

    override fun getPokedex(): Set<Int> {
        return pokedex
    }

    override fun addPokemon(id: Int) {
        pokedex.add(id)
    }

    override fun removePokemon(id: Int) {
        pokedex.remove(id)
    }
}