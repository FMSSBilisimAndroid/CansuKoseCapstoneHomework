package com.example.patikacapstoneproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.databinding.RecyclerviewMightneedTravelBinding
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener

class TravelsMightneedAdapter (
    private val travels: List<Travel>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<TravelsMightneedAdapter.MightneedTravelsViewHolder>(){

    override fun getItemCount() = travels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MightneedTravelsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_mightneed_travel,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MightneedTravelsViewHolder, position: Int) {
        holder.recyclerviewMightneedTravelBinding.travel = travels[position]

    }


    inner class MightneedTravelsViewHolder(
        val recyclerviewMightneedTravelBinding: RecyclerviewMightneedTravelBinding
    ) : RecyclerView.ViewHolder(recyclerviewMightneedTravelBinding.root)

}