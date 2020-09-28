package com.example.weatherforecast.di

import com.example.weatherforecast.view.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { WeatherViewModel(get()) }
}