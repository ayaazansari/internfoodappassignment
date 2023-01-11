package com.example.internfoodapp.ui.fragment

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internfoodapp.R
import com.example.internfoodapp.adapter.DashboardFragmentAdapter
import com.example.internfoodapp.model.Restaurant
import com.example.internfoodapp.repository.FoodRepository
import com.example.internfoodapp.ui.FoodViewModel
import com.example.internfoodapp.ui.FoodViewModelProviderFactory
import com.example.internfoodapp.util.Resource
import kotlinx.android.synthetic.main.fragment_dashboard.*
import java.util.*

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    lateinit var viewModel: FoodViewModel
    lateinit var dashboardAdapter:DashboardFragmentAdapter

//    var restaurantList :MutableLiveData<List<Restaurant>> = MutableLiveData()
    var restaurantList :List<Restaurant> = listOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodRepository = FoodRepository()
        val viewModelProviderFactory = FoodViewModelProviderFactory(foodRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(FoodViewModel::class.java)

        etSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(strTyped: Editable?) {
                filterFun(strTyped.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

        viewModel.restaurantInfoList.observe(viewLifecycleOwner, Observer { response->
            when(response){
                is Resource.Success ->{
                    hideProgressBar()
                    response.data?.let { foodResponse ->
//                        newsAdapter.differ.submitList(newsResponse.articles)
//                        restaurantList.postValue(foodResponse.data.data)
                        restaurantList = foodResponse.data.data
                        dashboardAdapter = DashboardFragmentAdapter(activity as Context, foodResponse.data.data)
                        recyclerViewDashboard.adapter = dashboardAdapter
                        recyclerViewDashboard.layoutManager = LinearLayoutManager(activity)
                        Log.e("Ayaaz","$foodResponse")
                    }
                }
                is Resource.Error ->{
                    hideProgressBar()
                    response?.message?.let { message->
                        Log.e(TAG,"an error occurred: $message")
                    }
                }
                is Resource.Loading ->{
                    showProgressBar()
                }
            }
        })

    }



    private fun filterFun(strTyped: String) {
        Log.e("Ayaaz","$strTyped")
        val filteredList = arrayListOf<Restaurant>()

        for (item in restaurantList) {
            if (item.name.toLowerCase(Locale.ROOT)
                    .contains(strTyped.toLowerCase(Locale.ROOT))
            ) {
                filteredList.add(item)
            }
        }

        if (filteredList.size == 0) {
            cantFind.visibility = View.VISIBLE
        } else {
            cantFind.visibility = View.INVISIBLE
        }

        dashboardAdapter.filterList(filteredList)

    }

    private fun hideProgressBar(){
        paginationProgressBar.visibility = View.GONE
    }

    private fun showProgressBar(){
        paginationProgressBar.visibility = View.VISIBLE
    }


//    private fun setupRecyclerView(){
//        newsAdapter = NewsAdapter()
//        rvBreakingNews.apply {
//            adapter = newsAdapter
//            layoutManager = LinearLayoutManager(activity)
//        }
//    }
}