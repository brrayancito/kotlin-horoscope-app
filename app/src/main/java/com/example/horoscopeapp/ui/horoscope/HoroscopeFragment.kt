package com.example.horoscopeapp.ui.horoscope

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.horoscopeapp.databinding.FragmentHoroscopeBinding
import com.example.horoscopeapp.domain.model.HoroscopeInf
import com.example.horoscopeapp.domain.model.HoroscopeInf.*
import com.example.horoscopeapp.domain.model.HoroscopeType
import com.example.horoscopeapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter() { item -> onItemSelected(item) }

        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
//        binding.rvHoroscope.layoutManager =
//        binding.rvHoroscope.adapter = horoscopeAdapter
    }

    private fun onItemSelected(item: HoroscopeInf) {
        val type = when(item) {
            Aquarius -> HoroscopeType.Aquarius
            Aries -> HoroscopeType.Aries
            Cancer -> HoroscopeType.Cancer
            Capricorn -> HoroscopeType.Capricorn
            Gemini -> HoroscopeType.Gemini
            Leo -> HoroscopeType.Leo
            Libra -> HoroscopeType.Libra
            Pisces -> HoroscopeType.Pisces
            Sagittarius -> HoroscopeType.Sagittarius
            Scorpio -> HoroscopeType.Scorpio
            Taurus -> HoroscopeType.Taurus
            Virgo -> HoroscopeType.Virgo
        }
        findNavController().navigate(
            // Navigate from HoroscopeFragment to HoroscopeDetailActivity
            HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
        )
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    horoscopeAdapter.updateHoroscopeList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}