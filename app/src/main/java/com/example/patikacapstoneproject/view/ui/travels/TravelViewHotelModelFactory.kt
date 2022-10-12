package com.example.patikacapstoneproject.view.ui.travels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.patikacapstoneproject.repository.TravelRepository
import com.example.patikacapstoneproject.viewmodel.MainViewFlightModel
import com.example.patikacapstoneproject.viewmodel.MainViewHotelModel

@Suppress("UNCHECKED_CAST")
class TravelViewHotelModelFactory(
    private val repository: TravelRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewHotelModel(repository) as T
    }

}