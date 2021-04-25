package fr.o80.everythingisfine.data

interface PokedexRepository {
    fun getPokedex(): Set<Int>
    fun addPokemon(id: Int)
    fun removePokemon(id: Int)
}