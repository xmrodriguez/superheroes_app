package com.superheroes.domain.usecase

import com.superheroes.data.repository.SuperHeroRepository
import com.superheroes.domain.model.SuperHero

class GetSuperHeroByName(private val superHeroesRepository: SuperHeroRepository) {

    operator fun invoke(name: String): SuperHero = superHeroesRepository.getByName(name)
}