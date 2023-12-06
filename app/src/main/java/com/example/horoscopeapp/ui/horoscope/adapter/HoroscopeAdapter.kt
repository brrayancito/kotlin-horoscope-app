package com.example.horoscopeapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopeapp.R
import com.example.horoscopeapp.domain.model.HoroscopeInf

class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInf> = emptyList(),
    private val onItemSelected: (HoroscopeInf) -> Unit
) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateHoroscopeList(list: List<HoroscopeInf>) {
        horoscopeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun getItemCount() = horoscopeList.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onItemSelected)
    }

}