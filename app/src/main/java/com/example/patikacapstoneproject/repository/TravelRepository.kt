package com.example.patikacapstoneproject.repository

import android.annotation.SuppressLint
import com.example.patikacapstoneproject.RetrofitClientInstance
import com.example.patikacapstoneproject.dao.ITravelDAO
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse


class TravelRepository {

    suspend fun fetchTravels() : List<Travel>? {
         return withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(ITravelDAO::class.java)
            val travels = async {service?.getAllTravels()}
            var result = travels.await()?.awaitResponse()?.body()
            return@withContext result
        }
    }

    @SuppressLint("SuspiciousIndentation")
    suspend fun fetchCategoryTravels(category: String ) : List<Travel>? {
        return withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(ITravelDAO::class.java)
            val travels = async {service?.getAllTravels()}
            var result = travels.await()?.awaitResponse()?.body()
            var itemOrder = ArrayList<Travel>()
            if (result != null) {
                for(r in result){
                    if(r.category == category){
                        itemOrder.add(r)
                    }
                }
            }
            return@withContext itemOrder
        }
    }

    @SuppressLint("SuspiciousIndentation")
    suspend fun fetchCategoryTravels(category: String , country: String) : List<Travel>? {
        return withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(ITravelDAO::class.java)
            val travels = async {service?.getAllTravels()}
            var result = travels.await()?.awaitResponse()?.body()
            var itemOrder = ArrayList<Travel>()
            if (result != null) {
                for(r in result){
                    if(r.category == category && r.country == country){
                        itemOrder.add(r)
                    }
                }
            }
            return@withContext itemOrder
        }
    }

}
