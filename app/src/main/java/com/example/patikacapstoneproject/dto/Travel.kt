package com.example.patikacapstoneproject.dto

import com.google.gson.annotations.SerializedName


data class Travel(
    var title : String,
    var description : String,
    @SerializedName("category") var category : String,
    var country : String,
    var city : String,
    var images : List<Image>,
    var isBookmark : Boolean,
    var id : String ) {

    override fun toString(): String {
        return title
    }
}
