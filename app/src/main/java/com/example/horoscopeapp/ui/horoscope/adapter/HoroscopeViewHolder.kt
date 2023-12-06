package com.example.horoscopeapp.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopeapp.databinding.ItemHoroscopeBinding
import com.example.horoscopeapp.domain.model.HoroscopeInf

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInf: HoroscopeInf) {
        binding.ivHoroscopeImage.setImageResource(horoscopeInf.imagen)
        binding.tvHoroscopeName.text = binding.tvHoroscopeName.context.getString(horoscopeInf.name)

    }
}