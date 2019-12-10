package com.example.pokemonapp

import retrofit2.Call

import retrofit2.http.GET

interface APIService {

    @GET("pokedex.json")
    fun getPokemonList(): Call<PokemonRespuesta>


}