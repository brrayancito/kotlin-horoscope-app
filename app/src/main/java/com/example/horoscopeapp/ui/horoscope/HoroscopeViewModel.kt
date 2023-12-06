package com.example.horoscopeapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscopeapp.data.providers.HoroscopeProvider
import com.example.horoscopeapp.domain.model.HoroscopeInf
import com.example.horoscopeapp.domain.model.HoroscopeInf.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider) :
    ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInf>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInf>> = _horoscope

    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }
}