package com.example.win27.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ManchesterModel(
    @SerializedName("manchesterunitedquiz")
    val manchester: List<Realmadrid>
)
