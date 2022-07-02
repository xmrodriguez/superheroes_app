package com.superheroes.ui.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.superheroes.R
import com.superheroes.domain.model.SuperHero
import com.superheroes.ui.presenter.SuperHeroesPresenter
import com.superheroes.ui.utils.setImageBackground

class SuperHeroViewHolder(
    itemView: View,
    private val presenter: SuperHeroesPresenter
) : RecyclerView.ViewHolder(itemView) {

    private val photoImageView: ImageView = itemView.findViewById(R.id.iv_super_hero_photo)
    private val nameTextView: TextView = itemView.findViewById(R.id.tv_super_hero_name)

    fun render(superHero: SuperHero) {
        hookListeners(superHero)
        renderSuperHeroPhoto(superHero.image)
        renderSuperHeroName(superHero.name)
    }

    private fun hookListeners(superHero: SuperHero) {
        itemView.setOnClickListener { presenter.onSuperHeroClicked(superHero) }
    }

    private fun renderSuperHeroPhoto(photo: String?) {
        photoImageView.setImageBackground(photo)
    }

    private fun renderSuperHeroName(name: String) {
        nameTextView.text = name
    }
}