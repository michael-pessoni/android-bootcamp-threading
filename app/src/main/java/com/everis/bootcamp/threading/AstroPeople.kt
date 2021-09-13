package com.everis.bootcamp.threading

import com.google.gson.annotations.SerializedName


data class AstroPeople(
    @SerializedName("name") val name:String,
    @SerializedName("craft") val craft: String
)
