package com.example.internfoodapp.api

import com.example.internfoodapp.model.FoodResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface NewsApi {

    @GET("/v2/restaurants/fetch_result/")
    suspend fun getRestaurant(
        @Header("token")
        token:String
    ): Response<FoodResponse>

}