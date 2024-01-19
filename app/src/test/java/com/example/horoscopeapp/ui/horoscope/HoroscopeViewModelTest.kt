package com.example.horoscopeapp.ui.horoscope

import com.example.horoscopeapp.data.providers.HoroscopeProvider
import com.example.horoscopeapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class HoroscopeViewModelTest {

    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewmodel is created then horoscope list must be loaded`() {
        every { horoscopeProvider.getHoroscopes() } returns horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscopeList = viewModel.horoscope.value

        assertTrue(horoscopeList.isNotEmpty())
        assertTrue(horoscopeList == viewModel.horoscope.value)
    }
}

