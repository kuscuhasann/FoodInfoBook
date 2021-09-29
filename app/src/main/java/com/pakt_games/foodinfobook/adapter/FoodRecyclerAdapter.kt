package com.pakt_games.foodinfobook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.pakt_games.foodinfobook.R
import com.pakt_games.foodinfobook.databinding.FoodListRecyclerRowBinding
import com.pakt_games.foodinfobook.model.Food
import com.pakt_games.foodinfobook.util.createPlaceholder
import com.pakt_games.foodinfobook.util.downloadImage
import com.pakt_games.foodinfobook.view.FoodListFragmentDirections
import kotlinx.android.synthetic.main.food_list_recycler_row.view.*

class FoodRecyclerAdapter(val foodList:ArrayList<Food>):RecyclerView.Adapter<FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        //attachToRoot if taking parameter true this line exception(WARN)
       val binding=FoodListRecyclerRowBinding.inflate(inflater,parent,false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.binding.model=foodList[position]
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun updateToFoodList(newFoodList:List<Food>)
    {
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()
    }

}