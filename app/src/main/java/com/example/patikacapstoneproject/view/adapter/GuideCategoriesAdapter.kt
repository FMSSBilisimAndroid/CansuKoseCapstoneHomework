package com.example.patikacapstoneproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.databinding.RecyclerviewGuidecategoryBinding
import com.example.patikacapstoneproject.dto.GuideCategory
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener

class GuideCategoriesAdapter (
    private val guideCategories: List<GuideCategory>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<GuideCategoriesAdapter.GuideCategoriesViewHolder>(){

    override fun getItemCount() = guideCategories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GuideCategoriesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_guidecategory,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: GuideCategoriesViewHolder, position: Int) {
        holder.recyclerviewGuidecategoryBinding.guideCategory = guideCategories[position]
    }


    inner class GuideCategoriesViewHolder(
        val recyclerviewGuidecategoryBinding: RecyclerviewGuidecategoryBinding
    ) : RecyclerView.ViewHolder(recyclerviewGuidecategoryBinding.root)

}