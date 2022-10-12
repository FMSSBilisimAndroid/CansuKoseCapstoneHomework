package com.example.patikacapstoneproject.dto


data class GuideCategory(
    var icon : String,
    var title : String,
    var id : String) {

    override fun toString(): String {
        return title
    }
}
