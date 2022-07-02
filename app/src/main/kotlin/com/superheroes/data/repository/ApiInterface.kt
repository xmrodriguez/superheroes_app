package com.superheroes.data.repository

import com.superheroes.domain.model.SuperHero
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("volley_array.json")
    fun getSuperHeroes() : Call<List<SuperHero>>

    companion object {

        var BASE_URL = "https://superheroapi.com/api/3303355196613708/5/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}