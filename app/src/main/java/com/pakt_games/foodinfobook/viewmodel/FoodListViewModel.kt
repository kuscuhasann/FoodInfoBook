package com.pakt_games.foodinfobook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pakt_games.foodinfobook.model.Food
import com.pakt_games.foodinfobook.service.FoodAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FoodListViewModel:ViewModel() {
    val foods=MutableLiveData<List<Food>>()
    val foodWarnMessage=MutableLiveData<Boolean>()
    val isFoodLoading=MutableLiveData<Boolean>()

    private val foodAPIService=FoodAPIService()
    private val disposable=CompositeDisposable()


    fun refleshData()
    {
       getDataFromAPI()
    }

    fun getDataFromAPI()
    {
        isFoodLoading.value=true

        disposable.add(
            foodAPIService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<List<Food>>(){
                    override fun onSuccess(t: List<Food>) {
                        foods.value=t
                        foodWarnMessage.value=false
                        isFoodLoading.value=false
                    }

                    override fun onError(e: Throwable) {
                        foodWarnMessage.value=true
                        isFoodLoading.value=false
                        e.printStackTrace()
                    }

                })

        )

    }
}