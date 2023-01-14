package com.example.win27.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class BarcelonaModel(
    @SerializedName("barcelonaquiz")
    val barcelona: List<Realmadrid>
)