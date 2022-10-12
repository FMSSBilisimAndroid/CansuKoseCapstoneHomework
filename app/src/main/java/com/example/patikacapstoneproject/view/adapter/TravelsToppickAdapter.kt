package com.example.patikacapstoneproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.databinding.RecyclerviewToppickTravelBinding
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener

class TravelsToppickAdapter (
    private val travels: List<Travel>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<TravelsToppickAdapter.ToppickTravelsViewHolder>(){

    override fun getItemCount() = travels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ToppickTravelsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_toppick_travel,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ToppickTravelsViewHolder, position: Int) {
        holder.recyclerviewToppickTravelBinding.travel = travels[position]
    }


    inner class ToppickTravelsViewHolder(
        val recyclerviewToppickTravelBinding: RecyclerviewToppickTravelBinding
    ) : RecyclerView.ViewHolder(recyclerviewToppickTravelBinding.root)

}