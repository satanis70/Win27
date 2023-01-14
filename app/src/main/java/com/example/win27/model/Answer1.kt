package com.example.win27.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Answer1(
    @SerializedName("name")
    val name: String,
    @SerializedName("trueorfalse")
    val trueorfalse: String
)