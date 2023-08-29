package com.devapps.mwyouthfootballportal.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    val BASE_URL = "http://192.168.182.48:4500"

    fun getRetrofitInstance() : Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}