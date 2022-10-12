package com.example.patikacapstoneproject.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.repository.TravelRepository
import com.example.patikacapstoneproject.util.Coroutines
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewNearbyModel (var travelRepository : TravelRepository ) : ViewModel(){

    var travelsNearby: MutableLiveData<List<Travel>> = MutableLiveData<List<Travel>>()
    private lateinit var job: Job

    @SuppressLint("NullSafeMutableLiveData")
    fun fetchCategoryTravels(category: String ) {
        viewModelScope.launch {
            job = Coroutines.ioThenMain(
                { travelRepository.fetchCategoryTravels(category) },
                { travelsNearby.value = it }
            )
        }
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun fetchCategoryTravels(category: String, country: String ) {
        viewModelScope.launch {
            job = Coroutines.ioThenMain(
                { travelRepository.fetchCategoryTravels(category, country) },
                { travelsNearby.value = it }
            )
        }
    }

}