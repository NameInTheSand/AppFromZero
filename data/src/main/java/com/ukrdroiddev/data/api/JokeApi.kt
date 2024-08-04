package com.ukrdroiddev.data.api

import com.ukrdroiddev.data.entities.JokeResponse
import retrofit2.http.GET

interface JokeApi {

    @GET("jokes/random")
    suspend fun getRandomJoke(): JokeResponse
}