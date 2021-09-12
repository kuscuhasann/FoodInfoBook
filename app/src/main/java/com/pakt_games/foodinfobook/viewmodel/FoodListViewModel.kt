package com.pakt_games.foodinfobook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pakt_games.foodinfobook.model.Food

class FoodListViewModel:ViewModel() {
    val foods=MutableLiveData<List<Food>>()
    val foodWarnMessage=MutableLiveData<Boolean>()
    val isFoodLoading=MutableLiveData<Boolean>()

    fun refleshData()
    {
        //fake data
        val banana=Food("Muz","100","45","12","21","www.test.com")
        val apple=Food("Apple","200","25","111","121","www.test.com")
        val nutella=Food("Nutella","700","35","122","221","www.test.com")
        val beef=Food("Beef","500","65","132","213","www.test.com")

        val foodList= arrayListOf<Food>(banana,apple,nutella,beef)

        foods.value=foodList
        foodWarnMessage.value=false
        isFoodLoading.value=false
    }
}