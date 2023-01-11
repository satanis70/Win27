package com.example.win27.model


import com.google.gson.annotations.SerializedName

data class Answer1(
    @SerializedName("name")
    val name: String,
    @SerializedName("trueorfalse")
    val trueorfalse: String
)