package com.example.horoscopeapp.data.network.response


import com.example.horoscopeapp.motherobject.HoroscopeMotherObject
import io.kotlintest.shouldBe
import org.junit.Assert.*
import org.junit.Test

class SignResponseTest {

    @Test
    fun `todomain should return a correct PredictionModel`() {
        //Given
        val signResponse = HoroscopeMotherObject.signResponse

        //When
        val predictionModel = signResponse.toDomain()

        //Then
        predictionModel.sign shouldBe signResponse.sign
        predictionModel.prediction shouldBe signResponse.horoscope
    }
}