package com.example.patikacapstoneproject.view.ui.travels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.patikacapstoneproject.repository.TravelRepository
import com.example.patikacapstoneproject.viewmodel.MainViewNearbyModel
import com.example.patikacapstoneproject.viewmodel.MainViewToppickModel

@Suppress("UNCHECKED_CAST")
class TravelViewNearbyModelFactory(
    private val repository: TravelRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewNearbyModel(repository) as T
    }

}