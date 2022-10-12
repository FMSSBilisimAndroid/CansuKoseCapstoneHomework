package com.example.patikacapstoneproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.databinding.RecyclerviewHotelBinding
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener

class TravelsHotelAdapter (
    private val travels: List<Travel>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<TravelsHotelAdapter.HotelTravelsViewHolder>(){

    override fun getItemCount() = travels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HotelTravelsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_hotel,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: HotelTravelsViewHolder, position: Int) {
        holder.recyclerviewHotelTravelBinding.travel = travels[position]

    }


    inner class HotelTravelsViewHolder(
        val recyclerviewHotelTravelBinding: RecyclerviewHotelBinding
    ) : RecyclerView.ViewHolder(recyclerviewHotelTravelBinding.root)

}