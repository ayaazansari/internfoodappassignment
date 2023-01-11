package com.example.internfoodapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internfoodapp.model.FoodResponse
import com.example.internfoodapp.repository.FoodRepository
import com.example.internfoodapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class FoodViewModel(
    val foodRepository: FoodRepository
) : ViewModel() {

    val restaurantInfoList :MutableLiveData<Resource<FoodResponse>> = MutableLiveData()

    init {
        getFoodItems()
    }
    private fun getFoodItems() = viewModelScope.launch {
        restaurantInfoList.postValue(Resource.Loading())
        val response = foodRepository.getRestaurant()
        restaurantInfoList.postValue(handleResponse(response))
    }

    private fun handleResponse(response: Response<FoodResponse>):Resource<FoodResponse>{
        if(response.isSuccessful){
            response.body()?.let { resultResponse->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}











