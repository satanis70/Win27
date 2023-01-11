package com.example.win27.model


import com.google.gson.annotations.SerializedName

data class RealModel(
    @SerializedName("realmadrid")
    val realmadrid: List<Realmadrid>
)