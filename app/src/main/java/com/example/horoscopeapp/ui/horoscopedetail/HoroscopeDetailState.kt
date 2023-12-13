package com.example.horoscopeapp.ui.horoscopedetail

import com.example.horoscopeapp.domain.model.HoroscopeType


sealed class HoroscopeDetailState {
    data object Loading : HoroscopeDetailState()
    data class Error(val error: String) : HoroscopeDetailState()
    data class Success(val prediction: String, val sign: String, val horoscope: HoroscopeType) :
        HoroscopeDetailState()
}