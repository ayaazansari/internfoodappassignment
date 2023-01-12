package com.example.internfoodapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.internfoodapp.R
import com.example.internfoodapp.ui.fragment.DashboardFragment

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        val dashboardFragment = DashboardFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,dashboardFragment)
            commit()

        }
    }
}