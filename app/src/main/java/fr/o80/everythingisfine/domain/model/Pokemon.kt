package fr.o80.everythingisfine.domain.model

/**
 * Created by Lucas Pommateau on 17/05/2021.
 * Copyright (c) 2021 Groupe SEB
 **/
data class Pokemon(
    val id: Int,
    val name: String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    var isAttrapped: Boolean
)