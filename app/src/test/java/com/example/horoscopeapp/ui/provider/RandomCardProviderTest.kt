package com.example.horoscopeapp.ui.provider

import org.junit.Assert.*
import org.junit.Test

class RandomCardProviderTest {

    @Test
    fun `getRandomCard should return a random card`() {
        //Given
        val randonCardProvider = RandomCardProvider()

        //When
        val card = randonCardProvider.getLucky()

        //Then
        assertNotNull(card)
    }
}