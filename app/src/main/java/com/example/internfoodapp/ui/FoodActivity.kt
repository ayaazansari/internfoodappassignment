package com.example.internfoodapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.internfoodapp.R
import com.example.internfoodapp.repository.FoodRepository

class FoodActivity : AppCompatActivity() {
    lateinit var viewModel: FoodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val foodRepository = FoodRepository()
        val viewModelProviderFactory = FoodViewModelProviderFactory(foodRepository)

        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(FoodViewModel::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.foodNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

    }
}