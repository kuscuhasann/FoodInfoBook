package com.pakt_games.foodinfobook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pakt_games.foodinfobook.model.Food

class FoodDetailViewModel:ViewModel() {
    val foodLiveData= MutableLiveData<Food>()

    fun getRoomData()
    {
        val banana=Food("Muz","100","45","12","21","www.test.com")
        foodLiveData.value=banana
    }

}