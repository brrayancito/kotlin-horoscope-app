package com.example.horoscopeapp.data.providers

import com.example.horoscopeapp.domain.model.HoroscopeInf
import com.example.horoscopeapp.domain.model.HoroscopeInf.*
import javax.inject.Inject


class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes() : List<HoroscopeInf> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}