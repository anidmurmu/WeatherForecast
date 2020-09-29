package com.example.weatherforecast.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.base.Resource
import com.example.domain.base.Status
import com.example.domain.model.CurrentWeatherUiModel
import com.example.domain.usecase.GetCurrentWeatherUseCase
import com.example.ui.base.RxAwareViewModel
import com.example.ui.base.ViewOnClickListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.plusAssign

class WeatherViewModel(private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase) : RxAwareViewModel(), ViewOnClickListener {

    private val _weatherInfoMutableLiveData = MutableLiveData<WeatherViewState>()
    val weatherInfo: LiveData<WeatherViewState> = _weatherInfoMutableLiveData

    fun init() {
        _weatherInfoMutableLiveData.value = WeatherViewState(Status.LOADING)
    }

    fun getGetCurrentWeather(city: String) {
      disposable += getCurrentWeatherUseCase
          .getCurrentWeather(city)
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(this::onGettingCurrentWeather)
    }

    private fun onGettingCurrentWeather(resource: Resource<CurrentWeatherUiModel>) {
        statusState.postValue(resource.transformStatus())

        if(resource.error != null) {
            return
        }

        if(resource.data == null) {
            return
        }

        _weatherInfoMutableLiveData.value = WeatherViewState(
            status = resource.status,
            data = resource.data,
            error = resource.error
        )
    }

}