package com.example.internfoodapp.repository

import com.example.internfoodapp.api.RetrofitInstance
import com.example.internfoodapp.util.Constants.Companion.TOKEN

class FoodRepository {
    suspend fun getRestaurant() = RetrofitInstance.api.getRestaurant(TOKEN)
}