package com.ukrdroiddev.data.repositories

import com.ukrdroiddev.data.api.JokeApi
import com.ukrdroiddev.data.entities.JokeResponse.Companion.toJoke
import com.ukrdroiddev.data.utils.wrapWithExceptions
import com.ukrdroiddev.domain.repositories.JokeRepository
import com.ukrdroiddev.entities.Joke
import com.ukrdroiddev.utils.NetworkError
import com.ukrdroiddev.utils.Result

class JokeRepositoryImpl(
    private val api: JokeApi
) : JokeRepository {

    override suspend fun getRandomJoke(): Result<Joke, NetworkError> {
        val response = wrapWithExceptions { api.getRandomJoke() }

        return when (response) {
            is Result.Success -> Result.Success(response.data.toJoke())
            is Result.Error -> Result.Error(response.error)
        }
    }

}
