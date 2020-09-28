package com.example.data.network.repositoryimpl

import applyLoading
import com.example.data.network.mapper.WeatherModelResponseMapper
import com.example.data.network.service.WeatherService
import com.example.domain.base.Resource
import com.example.domain.model.CurrentWeatherUiModel
import com.example.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class WeatherRepositoryImpl(private val dataSource: WeatherService,
private val currentWeatherModelResponseMapper: WeatherModelResponseMapper) : WeatherRepository {

    override fun getCurrentWeather(city: String): Observable<Resource<CurrentWeatherUiModel>> {
        return dataSource
            .getCurrentWeather(city)
            .map { Resource.success(it.let { currentWeatherModelResponseMapper.mapFrom(it) }) }
            .onErrorReturn { Resource.error(it) }
            .subscribeOn(Schedulers.io())
            .compose(applyLoading())
    }
}