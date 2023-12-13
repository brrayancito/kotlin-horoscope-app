package com.example.horoscopeapp.ui.horoscopedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscopeapp.domain.model.HoroscopeType
import com.example.horoscopeapp.domain.model.PredictionModel
import com.example.horoscopeapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope: HoroscopeType
    fun getSignInfo(sign: HoroscopeType) {
        horoscope = sign
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.Loading // Principal thread
//        getPredictionUseCase.invoke()
            val response: PredictionModel? =
                withContext(Dispatchers.IO) { getPredictionUseCase(sign.name) } // Executing in another thread
            // Principal thread
            if (response != null) _state.value =
                HoroscopeDetailState.Success(response.prediction, response.sign, horoscope)
            else _state.value = HoroscopeDetailState.Error("Something went wrong! Try again later.")


        }
    }
}