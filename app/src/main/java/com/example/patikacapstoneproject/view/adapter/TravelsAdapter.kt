package com.example.patikacapstoneproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.databinding.RecyclerviewTravelBinding
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener

class TravelsAdapter (
    private val travels: List<Travel>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<TravelsAdapter.TravelsViewHolder>(){

    override fun getItemCount() = travels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TravelsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_travel,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: TravelsViewHolder, position: Int) {
        holder.recyclerviewTravelBinding.travel = travels[position]
    }


    inner class TravelsViewHolder(
        val recyclerviewTravelBinding: RecyclerviewTravelBinding
    ) : RecyclerView.ViewHolder(recyclerviewTravelBinding.root)

}