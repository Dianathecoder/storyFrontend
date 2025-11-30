package com.example.cuentosfrontend.data.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "http://192.168.1.136:8081/"


    private val okHttp = OkHttpClient.Builder().build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val userApi = retrofit.create(ApiService::class.java)
}