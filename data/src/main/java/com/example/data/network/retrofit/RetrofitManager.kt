package com.example.data.network.retrofit

import NetworkMonitorInterceptor
import android.content.Context
import com.example.data.network.interceptor.QueryInterceptor
import com.example.data.network.interceptor.appIdKey
import com.example.data.network.interceptor.appIdValue
import com.readystatesoftware.chuck.ChuckInterceptor
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

fun createNetworkClient(context: Context): Retrofit {
  val httpClient = OkHttpClient.Builder()
    .addInterceptor(ChuckInterceptor(context))
    .addInterceptor(NetworkMonitorInterceptor(context))
    .addInterceptor(QueryInterceptor(appIdKey, appIdValue))
    .connectTimeout(25, TimeUnit.SECONDS)
    .readTimeout(25, TimeUnit.SECONDS)
    .writeTimeout(25, TimeUnit.SECONDS)

  return Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .client(httpClient.build())
    .build()
}
