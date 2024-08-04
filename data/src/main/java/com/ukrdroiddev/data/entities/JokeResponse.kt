package com.ukrdroiddev.data.entities

import com.google.gson.annotations.SerializedName
import com.ukrdroiddev.entities.Joke

data class JokeResponse(
    val categories: List<String>,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("icon_url")
    val iconUrl: String,
    val id: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    val url: String,
    val value: String
) {

    companion object{
        fun JokeResponse.toJoke(): Joke {
            return Joke(joke = value)
        }
    }
}
