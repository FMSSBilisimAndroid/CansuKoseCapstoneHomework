package com.example.patikacapstoneproject.view.ui.travels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.patikacapstoneproject.repository.TravelRepository
import com.example.patikacapstoneproject.viewmodel.MainViewMightneedModel

@Suppress("UNCHECKED_CAST")
class TravelViewMightneedModelFactory(
    private val repository: TravelRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewMightneedModel(repository) as T
    }

}