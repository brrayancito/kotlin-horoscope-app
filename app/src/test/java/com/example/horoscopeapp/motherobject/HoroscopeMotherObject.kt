package com.example.horoscopeapp.motherobject

import com.example.horoscopeapp.data.network.response.SignResponse
import com.example.horoscopeapp.domain.model.HoroscopeInf

object HoroscopeMotherObject {
    val signResponse = SignResponse("the date", "the prediction", "aries")

    val horoscopeInfoList = listOf(
        HoroscopeInf.Aries,
        HoroscopeInf.Taurus,
        HoroscopeInf.Gemini,
        HoroscopeInf.Cancer,
        HoroscopeInf.Leo,
        HoroscopeInf.Virgo,
        HoroscopeInf.Libra,
        HoroscopeInf.Scorpio,
        HoroscopeInf.Sagittarius,
        HoroscopeInf.Capricorn,
        HoroscopeInf.Aquarius,
        HoroscopeInf.Pisces
    )
}