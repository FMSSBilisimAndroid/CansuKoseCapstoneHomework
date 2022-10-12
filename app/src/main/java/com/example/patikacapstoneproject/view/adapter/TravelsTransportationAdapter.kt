package com.example.patikacapstoneproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.databinding.RecyclerviewTransportationBinding
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener

class TravelsTransportationAdapter (
    private val travels: List<Travel>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<TravelsTransportationAdapter.TransportationTravelsViewHolder>(){

    override fun getItemCount() = travels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TransportationTravelsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_transportation,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: TransportationTravelsViewHolder, position: Int) {
        holder.recyclerviewTransportationTravelBinding.travel = travels[position]
    }


    inner class TransportationTravelsViewHolder(
        val recyclerviewTransportationTravelBinding: RecyclerviewTransportationBinding
    ) : RecyclerView.ViewHolder(recyclerviewTransportationTravelBinding.root)

}