package com.example.internfoodapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internfoodapp.R
import com.example.internfoodapp.model.Restaurant
import com.squareup.picasso.Picasso


class DashboardFragmentAdapter(val context: Context, var itemList: List<Restaurant>) :
    RecyclerView.Adapter<DashboardFragmentAdapter.ViewHolderDashboard>() {

    class ViewHolderDashboard(view: View) : RecyclerView.ViewHolder(view) {
        val imgRestaurant: ImageView = view.findViewById(R.id.imgRestaurant)
        val txtRestaurantName: TextView = view.findViewById(R.id.txtRestaurantName)
        val txtPrice: TextView = view.findViewById(R.id.txtPrice)
        val txtRating: TextView = view.findViewById(R.id.txtRating)
        val llContent: LinearLayout = view.findViewById(R.id.llContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDashboard {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dashboard_recycler_view_single_row, parent, false)

        return ViewHolderDashboard(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolderDashboard, position: Int) {

        val restaurant = itemList[position]

        holder.txtRestaurantName.tag = restaurant.id
        holder.txtRestaurantName.text = restaurant.name
        holder.txtPrice.text = restaurant.cost_for_one + "/Person"
        holder.txtRating.text = restaurant.rating

        //Load images using Picasso
        Picasso.get().load(restaurant.image_url).error(R.drawable.ic_default_image_restaurant)
            .into(holder.imgRestaurant)

    }

    fun filterList(filteredList: ArrayList<Restaurant>) {
        itemList = filteredList
        notifyDataSetChanged()
    }
}

