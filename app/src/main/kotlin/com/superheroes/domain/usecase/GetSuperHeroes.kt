package com.superheroes.domain.usecase

import com.superheroes.data.repository.SuperHeroRepository
import com.superheroes.domain.model.SuperHero

class GetSuperHeroes(private val superHeroesRepository: SuperHeroRepository) {

    operator fun invoke(): List<SuperHero> = superHeroesRepository.getAllSuperHeroes()
}