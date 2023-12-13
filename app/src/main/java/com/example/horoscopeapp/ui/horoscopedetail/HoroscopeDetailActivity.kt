package com.example.horoscopeapp.ui.horoscopedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscopeapp.R
import com.example.horoscopeapp.databinding.ActivityHoroscopeDetailBinding
import com.example.horoscopeapp.domain.model.HoroscopeType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    //Get arguments from horoscopeFragment
    private val arguments: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopeDetailViewModel.getSignInfo(arguments.type)
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        is HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.loading.isVisible = false
        binding.tvHoroscopeName.text = state.sign
        binding.tvHoroscopeDescription.text = state.prediction

        val imgResource = when (state.horoscope) {
            HoroscopeType.Aries -> R.drawable.detail_aries
            HoroscopeType.Taurus -> R.drawable.detail_taurus
            HoroscopeType.Gemini -> R.drawable.detail_gemini
            HoroscopeType.Cancer -> R.drawable.detail_cancer
            HoroscopeType.Leo -> R.drawable.detail_leo
            HoroscopeType.Virgo -> R.drawable.detail_virgo
            HoroscopeType.Libra -> R.drawable.detail_libra
            HoroscopeType.Scorpio -> R.drawable.detail_scorpio
            HoroscopeType.Sagittarius -> R.drawable.detail_sagittarius
            HoroscopeType.Capricorn -> R.drawable.detail_capricorn
            HoroscopeType.Aquarius -> R.drawable.detail_aquarius
            HoroscopeType.Pisces -> R.drawable.detail_pisces
        }

        binding.ivHoroscope.setImageResource(imgResource)
    }

    private fun errorState() {
        binding.loading.isVisible = false

    }

    private fun loadingState() {
        binding.loading.isVisible = true

    }
}
