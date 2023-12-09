package com.example.horoscopeapp.data.network.response

import com.example.horoscopeapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class SignResponse(
    @SerializedName("date") val data: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
) {
    fun toDomain(): PredictionModel {
        return PredictionModel(prediction = horoscope, sign = sign)
    }
}
