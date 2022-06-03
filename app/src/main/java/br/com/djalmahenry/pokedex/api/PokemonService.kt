package br.com.djalmahenry.pokedex.api

import br.com.djalmahenry.pokedex.api.model.PokemonApiResult
import br.com.djalmahenry.pokedex.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(number: Int): Call<PokemonApiResult>
}