package com.pakt_games.foodinfobook.service

import com.pakt_games.foodinfobook.model.Food
import io.reactivex.Single
import retrofit2.http.GET

interface FoodAPI {

    //https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    //BASE URL https://raw.githubusercontent.com/

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getFood():Single<List<Food>>
}