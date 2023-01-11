//package com.example.internfoodapp.adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.RelativeLayout
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class RestaurantMenuAdapter(
//    val context: Context,
//    val restaurantId: String,
//    val restaurantName: String,
//    val proceedToCartPassed: RelativeLayout,
//    val buttonProceedToCart: Button,
//    val restaurantMenu: ArrayList<RestaurantMenu>
//) : RecyclerView.Adapter<RestaurantMenuAdapter.ViewHolderRestaurantMenu>() {
//
//
//    var itemSelectedCount: Int = 0
//    lateinit var proceedToCart: RelativeLayout
//
//    class ViewHolderRestaurantMenu(view: View) : RecyclerView.ViewHolder(view) {
//        val txtSerialNumber: TextView = view.findViewById(R.id.txtSerialNumber)
//        val txtItemName: TextView = view.findViewById(R.id.txtItemName)
//        val txtItemPrice: TextView = view.findViewById(R.id.txtItemPrice)
//        val btnAddToCart: Button = view.findViewById(R.id.btnAddToCart)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRestaurantMenu {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.restaurant_menu_recycler_view_single_row, parent, false)
//
//        return ViewHolderRestaurantMenu(view)
//    }
//
//    override fun getItemCount(): Int {
//        return restaurantMenu.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolderRestaurantMenu, position: Int) {
//
//        val restaurantMenuItem = restaurantMenu[position]
//        proceedToCart = proceedToCartPassed
//        holder.btnAddToCart.tag = restaurantMenuItem.id + ""
//        holder.txtSerialNumber.text = (position + 1).toString()
//        holder.txtItemName.text = restaurantMenuItem.name
//        holder.txtItemPrice.text = "Rs. ${restaurantMenuItem.cost_for_one}"
//    }
//
//}