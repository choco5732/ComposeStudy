package kr.co.uxn.di

import okhttp3.Response
import retrofit2.http.GET

interface PokeAPI {
    @GET("pokemon/")
    suspend fun getPokemons(): Response
}