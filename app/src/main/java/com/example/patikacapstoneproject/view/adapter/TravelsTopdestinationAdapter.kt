package com.example.patikacapstoneproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.databinding.RecyclerviewTopdestinationTravelBinding
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener

class TravelsTopdestinationAdapter (
    private val travels: List<Travel>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<TravelsTopdestinationAdapter.TopdestinationTravelsViewHolder>(){

    override fun getItemCount() = travels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TopdestinationTravelsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_topdestination_travel,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: TopdestinationTravelsViewHolder, position: Int) {
        holder.recyclerviewTopdestinationTravelBinding.travel = travels[position]
//        holder.recyclerviewTopdestinationTravelBinding.imageView.setOnClickListener{
//            listener.onRecyclerViewItemClick( holder.recyclerviewTopdestinationTravelBinding.imageView, travels[position])
//        }
    }


    inner class TopdestinationTravelsViewHolder(
        val recyclerviewTopdestinationTravelBinding: RecyclerviewTopdestinationTravelBinding
    ) : RecyclerView.ViewHolder(recyclerviewTopdestinationTravelBinding.root)

}