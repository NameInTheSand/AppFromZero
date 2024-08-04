package com.ukrdroiddev.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    fun getService(): JokeApi {
        return getClient().create(JokeApi::class.java)
    }

    private fun getClient(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    private fun getOkHttpClient(): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return client
    }
}