package com.example.horoscopeapp.domain

import com.example.horoscopeapp.domain.model.PredictionModel

interface Repository {
    suspend fun getSignInfo(sing: String) : PredictionModel?
}