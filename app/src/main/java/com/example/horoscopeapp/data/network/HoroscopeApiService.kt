package com.example.horoscopeapp.data.network

import com.example.horoscopeapp.data.network.response.SignResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getSignInf(@Path("sign") sign: String) : SignResponse
}