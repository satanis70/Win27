package com.example.win27.services

import com.example.win27.model.BarcelonaModel
import com.example.win27.model.ManchesterModel
import com.example.win27.model.RealModel
import retrofit2.Call
import retrofit2.http.GET

interface QuizApi {
    @GET("realmadrid.json")
    fun getReal():Call<RealModel>
    @GET("barcelonaquiz.json")
    fun getBarcelona():Call<BarcelonaModel>
    @GET("manchesterunitedquiz.json")
    fun getManchester():Call<ManchesterModel>
}