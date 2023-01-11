package com.example.internfoodapp.repository

import com.example.internfoodapp.api.RetrofitInstance

class FoodRepository {
    suspend fun getRestaurant() = RetrofitInstance.api.getRestaurant("26c5144c5b9c13")
}