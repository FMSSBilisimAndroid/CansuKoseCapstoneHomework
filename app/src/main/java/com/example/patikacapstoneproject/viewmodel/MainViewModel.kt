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

class MainViewModel (var travelRepository : TravelRepository ) : ViewModel(){

    var travels: MutableLiveData<List<Travel>> = MutableLiveData<List<Travel>>()

    var travelsToppick: MutableLiveData<List<Travel>> = MutableLiveData<List<Travel>>()
    private lateinit var job: Job


    @SuppressLint("NullSafeMutableLiveData")
    fun fetchTravels() {
        viewModelScope.launch {
            var innerTravels = travelRepository.fetchTravels()
            travels.postValue(innerTravels)

        }
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun fetchCategoryTravels(category: String ) {
        viewModelScope.launch {
            job = Coroutines.ioThenMain(
                { travelRepository.fetchCategoryTravels(category) },
                { travelsToppick.value = it }
            )
        }
    }

}