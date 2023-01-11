package com.example.win27.services

import com.example.win27.model.RealModel
import retrofit2.Call
import retrofit2.http.GET

interface QuizApi {
    @GET("realmadrid.json")
    fun getReal():Call<RealModel>
}