package com.example.domain.di

import com.example.domain.usecase.GetCurrentWeatherUseCase
import com.example.domain.usecase.GetCurrentWeatherUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single<GetCurrentWeatherUseCase> { GetCurrentWeatherUseCaseImpl(get()) }
}