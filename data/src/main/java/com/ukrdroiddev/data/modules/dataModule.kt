package com.ukrdroiddev.data.modules

import com.ukrdroiddev.data.api.JokeApi
import com.ukrdroiddev.data.api.RetrofitBuilder
import com.ukrdroiddev.data.repositories.JokeRepositoryImpl
import com.ukrdroiddev.domain.repositories.JokeRepository
import org.koin.dsl.module

val datamodule = module {
    single<JokeApi> { RetrofitBuilder.getService() }
    single<JokeRepository> { JokeRepositoryImpl(get()) }
}