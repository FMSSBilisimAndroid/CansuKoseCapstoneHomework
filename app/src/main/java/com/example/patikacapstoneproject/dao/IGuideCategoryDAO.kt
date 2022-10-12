package com.example.patikacapstoneproject.dao

import com.example.patikacapstoneproject.dto.GuideCategory
import retrofit2.Call
import retrofit2.http.GET

interface IGuideCategoryDAO {

    @GET("/GuideCategories")
    fun getAllGuideCategories() : Call<ArrayList<GuideCategory>>

}