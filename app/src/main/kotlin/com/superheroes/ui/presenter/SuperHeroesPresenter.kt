package com.superheroes.ui.presenter

import android.arch.lifecycle.Lifecycle.Event.ON_DESTROY
import android.arch.lifecycle.Lifecycle.Event.ON_RESUME
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.superheroes.common.async
import com.superheroes.common.weak
import com.superheroes.domain.model.SuperHero
import com.superheroes.domain.usecase.GetSuperHeroes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SuperHeroesPresenter(
    view: View,
    private val getSuperHeroes: GetSuperHeroes
) : LifecycleObserver, CoroutineScope by MainScope() {

    private val view: View? by weak(view)

    @OnLifecycleEvent(ON_RESUME)
    fun update() {
        view?.showLoading()
        refreshSuperHeroes()
    }

    @OnLifecycleEvent(ON_DESTROY)
    fun destroy() {
        cancel()
    }

    private fun refreshSuperHeroes() = launch {
        val result = async { getSuperHeroes() }
        view?.hideLoading()
        when {
            result.isEmpty() -> view?.showEmptyCase()
            else -> view?.showSuperHeroes(result)
        }
    }

    fun onSuperHeroClicked(superHero: SuperHero) = view?.openDetail(superHero.name)

    interface View {
        fun hideLoading()
        fun showSuperHeroes(superHeroes: List<SuperHero>)
        fun showLoading()
        fun showEmptyCase()
        fun openDetail(name: String)
    }
}