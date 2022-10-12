package com.example.patikacapstoneproject.view.ui.guidecategories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.patikacapstoneproject.repository.GuideCategoryRepository
import com.example.patikacapstoneproject.viewmodel.GuideCategoryViewModel

@Suppress("UNCHECKED_CAST")
class GuideCategoryViewModelFactory(
    private val repository: GuideCategoryRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GuideCategoryViewModel(repository) as T
    }

}