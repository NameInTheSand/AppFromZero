package com.ukrdroiddev.presentation.module

import com.ukrdroiddev.presentation.viewModels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MainViewModel(get()) }
}