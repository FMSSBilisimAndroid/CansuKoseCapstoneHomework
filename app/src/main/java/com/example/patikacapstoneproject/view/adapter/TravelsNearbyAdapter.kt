package com.example.patikacapstoneproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.databinding.RecyclerviewNearbyTravelBinding
import com.example.patikacapstoneproject.databinding.RecyclerviewTravelBinding
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener

class TravelsNearbyAdapter (
    private val travels: List<Travel>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<TravelsNearbyAdapter.NearbyTravelsViewHolder>(){

    override fun getItemCount() = travels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NearbyTravelsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_nearby_travel,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NearbyTravelsViewHolder, position: Int) {
        holder.recyclerviewNearbyTravelBinding.travel = travels[position]
    }


    inner class NearbyTravelsViewHolder(
        val recyclerviewNearbyTravelBinding: RecyclerviewNearbyTravelBinding
    ) : RecyclerView.ViewHolder(recyclerviewNearbyTravelBinding.root)

}