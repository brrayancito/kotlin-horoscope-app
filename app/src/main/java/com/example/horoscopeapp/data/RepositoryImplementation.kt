package com.example.horoscopeapp.data

import android.util.Log
import com.example.horoscopeapp.data.network.HoroscopeApiService
import com.example.horoscopeapp.domain.Repository
import com.example.horoscopeapp.domain.model.PredictionModel
import javax.inject.Inject


class RepositoryImplementation @Inject constructor(private val apiService: HoroscopeApiService) :
    Repository {
    override suspend fun getSignInfo(sign: String): PredictionModel? {
        runCatching { apiService.getSignInf(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("javy", "Something went wrong! Error: ${it.message}") }

        return null
    }
}