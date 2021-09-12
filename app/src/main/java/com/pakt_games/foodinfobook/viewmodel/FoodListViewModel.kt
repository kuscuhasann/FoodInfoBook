package com.pakt_games.foodinfobook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pakt_games.foodinfobook.model.Food

class FoodListViewModel:ViewModel() {
    val foods=MutableLiveData<List<Food>>()
    val foodWarnMessage=MutableLiveData<Boolean>()
    val isFoodLoading=MutableLiveData<Boolean>()
}