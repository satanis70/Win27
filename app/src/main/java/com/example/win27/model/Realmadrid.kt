package com.example.win27.model


import com.google.gson.annotations.SerializedName

data class Realmadrid(
    @SerializedName("answer1")
    val answer1: Answer1,
    @SerializedName("answer2")
    val answer2: Answer1,
    @SerializedName("answer3")
    val answer3: Answer1,
    @SerializedName("answer4")
    val answer4: Answer1,
    @SerializedName("question")
    val question: String
)