package com.example.horoscopeapp.domain.usecase

import com.example.horoscopeapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getSignInfo(sign)
}