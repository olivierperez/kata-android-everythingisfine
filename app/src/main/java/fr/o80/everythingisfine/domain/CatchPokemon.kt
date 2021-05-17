package fr.o80.everythingisfine.domain

/**
 * Created by Lucas Pommateau on 17/05/2021.
 * Copyright (c) 2021 Groupe SEB
 **/
interface CatchPokemon {
    operator fun invoke(pokemonId: Int)
}