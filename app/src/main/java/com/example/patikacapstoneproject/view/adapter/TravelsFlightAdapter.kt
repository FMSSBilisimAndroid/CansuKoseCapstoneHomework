package com.example.patikacapstoneproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.databinding.RecyclerviewFlightBinding
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener

class TravelsFlightAdapter (
    private val travels: List<Travel>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<TravelsFlightAdapter.FlightTravelsViewHolder>(){

    override fun getItemCount() = travels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FlightTravelsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_flight,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FlightTravelsViewHolder, position: Int) {
        holder.recyclerviewFlightTravelBinding.travel = travels[position]

    }


    inner class FlightTravelsViewHolder(
        val recyclerviewFlightTravelBinding: RecyclerviewFlightBinding
    ) : RecyclerView.ViewHolder(recyclerviewFlightTravelBinding.root)

}