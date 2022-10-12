package com.example.patikacapstoneproject.repository

import com.example.patikacapstoneproject.RetrofitClientInstance
import com.example.patikacapstoneproject.dao.IGuideCategoryDAO
import com.example.patikacapstoneproject.dto.GuideCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

import retrofit2.Response
import java.io.IOException

class GuideCategoryRepository {

    suspend fun fetchGuideCategories() : List<GuideCategory>? {
         return withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(IGuideCategoryDAO::class.java)
            val guideCategories = async {service?.getAllGuideCategories()}
            var result = guideCategories.await()?.awaitResponse()?.body()
            return@withContext result
        }
    }

}
