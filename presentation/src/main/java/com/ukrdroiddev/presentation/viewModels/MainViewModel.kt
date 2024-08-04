package com.ukrdroiddev.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ukrdroiddev.domain.repositories.JokeRepository
import com.ukrdroiddev.entities.Joke
import com.ukrdroiddev.utils.NetworkError
import com.ukrdroiddev.utils.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: JokeRepository
) : ViewModel() {
    private val _jokeFlow = MutableStateFlow<Result<Joke, NetworkError>?>(null)
    val jokeFlow = _jokeFlow.asStateFlow()

    init {
        getRandomJoke()
    }

    fun getRandomJoke() {
        viewModelScope.launch {
            _jokeFlow.emit(repository.getRandomJoke())
        }
    }
}