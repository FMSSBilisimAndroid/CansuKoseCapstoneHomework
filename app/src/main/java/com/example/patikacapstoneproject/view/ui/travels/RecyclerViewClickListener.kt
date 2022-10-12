package com.example.patikacapstoneproject.view.ui.travels

import android.view.View
import com.example.patikacapstoneproject.dto.GuideCategory
import com.example.patikacapstoneproject.dto.Travel

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, travel: Travel)

    fun onRecyclerViewGuideCategoryClick(view: View, guideCategory: GuideCategory)
}