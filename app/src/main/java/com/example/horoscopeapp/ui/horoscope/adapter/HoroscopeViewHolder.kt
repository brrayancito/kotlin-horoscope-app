package com.example.horoscopeapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopeapp.databinding.ItemHoroscopeBinding
import com.example.horoscopeapp.domain.model.HoroscopeInf

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInf: HoroscopeInf, onItemSelected: (HoroscopeInf) -> Unit) {
        binding.ivHoroscopeImage.setImageResource(horoscopeInf.imagen)
        binding.tvHoroscopeName.text = binding.tvHoroscopeName.context.getString(horoscopeInf.name)

        binding.horoscopeItem.setOnClickListener {
            animation(binding.ivHoroscopeImage) { onItemSelected(horoscopeInf) }
        }
    }

    private fun animation(view: View, onItemSelected: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { onItemSelected() }
            start()
        }
    }
}