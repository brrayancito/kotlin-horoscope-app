package com.example.horoscopeapp.domain.model

import com.example.horoscopeapp.R

sealed class HoroscopeInf(val imagen: Int, val name: Int) {
    data object Aries : HoroscopeInf(R.drawable.ic_aries, R.string.aries)
    data object Taurus : HoroscopeInf(R.drawable.ic_taurus, R.string.taurus)
    data object Gemini : HoroscopeInf(R.drawable.ic_gemini, R.string.gemini)
    data object Cancer : HoroscopeInf(R.drawable.ic_cancer, R.string.cancer)
    data object Leo : HoroscopeInf(R.drawable.ic_leo, R.string.leo)
    data object Virgo : HoroscopeInf(R.drawable.ic_virgo, R.string.virgo)
    data object Libra : HoroscopeInf(R.drawable.ic_libra, R.string.libra)
    data object Scorpio : HoroscopeInf(R.drawable.ic_scorpio, R.string.scorpio)
    data object Sagittarius : HoroscopeInf(R.drawable.ic_sagittarius, R.string.sagittarius)
    data object Capricorn : HoroscopeInf(R.drawable.ic_capricorn, R.string.capricorn)
    data object Aquarius : HoroscopeInf(R.drawable.ic_aquarius, R.string.aquarius)
    data object Pisces : HoroscopeInf(R.drawable.ic_pisces, R.string.pisces)
}
