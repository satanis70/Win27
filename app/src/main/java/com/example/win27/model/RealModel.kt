package com.example.win27.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RealModel(
    @SerializedName("realmadrid")
    val realmadrid: List<Realmadrid>
)