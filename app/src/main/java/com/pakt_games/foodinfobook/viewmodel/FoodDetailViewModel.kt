package com.pakt_games.foodinfobook.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.pakt_games.foodinfobook.base.BaseViewModel
import com.pakt_games.foodinfobook.db.FoodDataBase
import com.pakt_games.foodinfobook.model.Food
import kotlinx.coroutines.launch

class FoodDetailViewModel(application: Application): BaseViewModel(application) {
    val foodLiveData= MutableLiveData<Food>()

    fun getRoomData(uuid: Int)
    {
        launch {
            val dao=FoodDataBase(getApplication()).foodDAO()
            val food=dao.getFood(uuid)
            foodLiveData.value=food
        }
    }

}