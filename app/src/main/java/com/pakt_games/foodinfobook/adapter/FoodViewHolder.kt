package com.pakt_games.foodinfobook.adapter

import androidx.recyclerview.widget.RecyclerView
import com.pakt_games.foodinfobook.databinding.FoodListRecyclerRowBinding
import com.pakt_games.foodinfobook.model.Food

class FoodViewHolder(val binding: FoodListRecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(rowModel: Food){
        binding.model=rowModel
        binding.executePendingBindings()
    }
}