package com.example.lovecalculate

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.Query

//  .addHeader("X-RapidAPI-Key", "ed79022b4bmsh600725ba2c9e3dbp12b6a6jsna7a8f4a4a202")
//	.addHeader("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")
interface LoveApi {
    @GET("getPercentage")
    fun getLove(
        @Query("fname") firstName : String,
        @Query("sname") secondName : String,
        @Header("X-RapidAPI-Key") key : String = "ed79022b4bmsh600725ba2c9e3dbp12b6a6jsna7a8f4a4a202",
        @Header("X-RapidAPI-Host") host : String = "love-calculator.p.rapidapi.com"
    ) : Call<LoveModel>
}