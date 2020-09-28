package com.example.domain.usecase

import com.example.domain.base.Resource
import com.example.domain.model.CurrentWeatherUiModel
import com.example.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable

interface GetCurrentWeatherUseCase {
    fun getCurrentWeather(city: String): Observable<Resource<CurrentWeatherUiModel>>
}

class GetCurrentWeatherUseCaseImpl(private val repository: WeatherRepository) : GetCurrentWeatherUseCase {
    override fun getCurrentWeather(city: String): Observable<Resource<CurrentWeatherUiModel>> {
        return repository
            .getCurrentWeather(city)
            .map { resource ->
                Resource(
                    status = resource.status,
                    data = resource.data,
                    error = resource.error
                )
            }
    }
}
