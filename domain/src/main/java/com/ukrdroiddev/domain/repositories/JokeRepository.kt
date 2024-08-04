package com.ukrdroiddev.domain.repositories

import com.ukrdroiddev.entities.Joke
import com.ukrdroiddev.utils.NetworkError
import com.ukrdroiddev.utils.Result

interface JokeRepository {

    suspend fun getRandomJoke(): Result<Joke, NetworkError>
}


