package com.pakt_games.foodinfobook.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pakt_games.foodinfobook.base.BaseViewModel
import com.pakt_games.foodinfobook.db.FoodDataBase
import com.pakt_games.foodinfobook.model.Food
import com.pakt_games.foodinfobook.service.FoodAPIService
import com.pakt_games.foodinfobook.util.SpecialSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class FoodListViewModel(application: Application): BaseViewModel(application) {
    val foods=MutableLiveData<List<Food>>()
    val foodWarnMessage=MutableLiveData<Boolean>()
    val isFoodLoading=MutableLiveData<Boolean>()

    private val foodAPIService=FoodAPIService()
    private val disposable=CompositeDisposable()
    private val specialSharedPreferences=SpecialSharedPreferences(getApplication())
    //nano time
    private val updateTime= 5 * 60 * 1000 * 1000 * 1000L


    fun refleshData()
    {
        val saveTime=specialSharedPreferences.getTime()
        if(saveTime != null && saveTime != 0L && System.nanoTime()-saveTime < updateTime)
        {
            getDataFromSQLite()
        }
        else
        {
            getDataFromAPI()
        }

    }
    fun getDataFromSQLite(){
        launch {
            val foodList = FoodDataBase(getApplication()).foodDAO().getAllFoods()
            showFoods(foodList)
        }
    }
    fun refleshFromInternet()
    {
        getDataFromAPI()
    }
    fun getDataFromAPI()
    {
        isFoodLoading.value=true

        disposable.add(
            foodAPIService.getData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<List<Food>>(){
                    override fun onSuccess(t: List<Food>) {
                        saveToDataInSQLite(t)
                    }

                    override fun onError(e: Throwable) {
                        foodWarnMessage.value=true
                        isFoodLoading.value=false
                        e.printStackTrace()
                    }
                })
        )
    }
    private fun showFoods(foodList:List<Food>){
        foods.value=foodList
        foodWarnMessage.value=false
        isFoodLoading.value=false
    }
    private fun saveToDataInSQLite(foodList:List<Food>){
        launch {
            val dao=FoodDataBase(getApplication()).foodDAO()
            dao.deleteAllFoods()
            val uuidList = dao.insertAll(*foodList.toTypedArray())
            dao.getAllFoods()
            var i=0
            while (i<foodList.size){
                foodList[i].uuid = uuidList[i].toInt()
                i=i+1
            }
            showFoods(foodList)
        }
        specialSharedPreferences.saveTime(System.nanoTime())
    }
}