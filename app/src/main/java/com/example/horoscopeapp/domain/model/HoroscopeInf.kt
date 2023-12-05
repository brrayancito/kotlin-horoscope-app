package com.example.horoscopeapp.domain.model

import com.example.horoscopeapp.R

sealed class HoroscopeInf(val imagen: Int, val name: Int) {
    object Aries : HoroscopeInf(R.drawable.ic_aries, R.string.aries)
    object Taurus : HoroscopeInf(R.drawable.ic_taurus, R.string.taurus)
    object Gemini : HoroscopeInf(R.drawable.ic_gemini, R.string.gemini)
    object Cancer : HoroscopeInf(R.drawable.ic_cancer, R.string.cancer)
    object Leo : HoroscopeInf(R.drawable.ic_leo, R.string.leo)
    object Virgo : HoroscopeInf(R.drawable.ic_virgo, R.string.virgo)
    object Libra : HoroscopeInf(R.drawable.ic_libra, R.string.libra)
    object Scorpio : HoroscopeInf(R.drawable.ic_scorpio, R.string.scorpio)
    object Sagittarius : HoroscopeInf(R.drawable.ic_sagittarius, R.string.sagittarius)
    object Capricorn : HoroscopeInf(R.drawable.ic_capricorn, R.string.capricorn)
    object Aquarius : HoroscopeInf(R.drawable.ic_aquarius, R.string.aquarius)
    object Pisces : HoroscopeInf(R.drawable.ic_pisces, R.string.pisces)
}
