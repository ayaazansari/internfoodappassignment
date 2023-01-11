package com.example.internfoodapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.internfoodapp.repository.FoodRepository

class FoodViewModelProviderFactory(
    private val newsRepository: FoodRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FoodViewModel(newsRepository) as T
    }
}