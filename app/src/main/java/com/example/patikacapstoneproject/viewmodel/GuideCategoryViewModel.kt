package com.example.patikacapstoneproject.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patikacapstoneproject.dto.GuideCategory
import com.example.patikacapstoneproject.repository.GuideCategoryRepository
import kotlinx.coroutines.launch

class GuideCategoryViewModel (var guideCategoryRepository : GuideCategoryRepository ) : ViewModel(){

    var guideCategories: MutableLiveData<List<GuideCategory>> = MutableLiveData<List<GuideCategory>>()


    @SuppressLint("NullSafeMutableLiveData")
    fun fetchGuideCategories() {
        viewModelScope.launch {
            var innerGuideCategories = guideCategoryRepository.fetchGuideCategories()
            guideCategories.postValue(innerGuideCategories)

        }
    }

}