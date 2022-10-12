package com.example.patikacapstoneproject.dao

import com.example.patikacapstoneproject.dto.Travel
import retrofit2.Call
import retrofit2.http.GET

interface ITravelDAO {

    @GET("/AllTravelList")
    fun getAllTravels() : Call<ArrayList<Travel>>

}