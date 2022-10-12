package com.example.patikacapstoneproject.dto

data class Image(var allText: String = "",
                 var height : Int = 0,
                 var width: Int = 0,
                 var url : String = ""){

    override fun toString(): String {
        return "Image(url='$url')"
    }

}
