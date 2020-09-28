package com.example.data.di

import com.example.data.network.mapper.WeatherModelResponseMapper
import com.example.data.network.repositoryimpl.WeatherRepositoryImpl
import com.example.data.network.retrofit.createNetworkClient
import com.example.data.network.service.WeatherService
import com.example.domain.repository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {
  single { (createNetworkClient(get())).create(WeatherService::class.java) }

  single { WeatherModelResponseMapper() }
  single<WeatherRepository> { WeatherRepositoryImpl(get(), get()) }
}
