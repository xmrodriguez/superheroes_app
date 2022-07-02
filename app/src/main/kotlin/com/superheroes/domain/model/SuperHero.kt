package com.superheroes.domain.model

data class SuperHero(
    val id: String,
    val name: String,
    val image: String?,
    val powerstats: String?,
    val biography: String?,
    val appearance: String?,
    val work: String?,
    val connections: String
)