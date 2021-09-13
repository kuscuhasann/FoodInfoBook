package com.pakt_games.foodinfobook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.pakt_games.foodinfobook.R
import com.pakt_games.foodinfobook.model.Food
import com.pakt_games.foodinfobook.view.FoodListFragmentDirections
import kotlinx.android.synthetic.main.food_list_recycler_row.view.*

class FoodRecyclerAdapter(val foodList:ArrayList<Food>):RecyclerView.Adapter<FoodRecyclerAdapter.FoodViewHolder>() {
    class FoodViewHolder(item: View ):RecyclerView.ViewHolder(item) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        //attachToRoot if taking parameter true this line exception(WARN)
        val view=inflater.inflate(R.layout.food_list_recycler_row,parent,false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.itemView.txtFoodNameIdAtRecyclerRow.text=foodList[position].foodName
        holder.itemView.txtFoodCalorieIdAtRecyclerRow.text=foodList[position].foodCalorie
        //Image to be add
        holder.itemView.setOnClickListener {
            val action=FoodListFragmentDirections.actionFoodListFragmentToFoodDetailFragment(0)
            Navigation.findNavController(it).navigate(action)

        }
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