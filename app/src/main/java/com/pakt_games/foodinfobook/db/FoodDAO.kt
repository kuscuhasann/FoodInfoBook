package com.pakt_games.foodinfobook.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pakt_games.foodinfobook.model.Food

@Dao
interface FoodDAO {
    @Insert
    suspend fun insertAll(vararg food:Food) : List<Long>
    @Query("SELECT * FROM FOOD")
    suspend fun getAllFoods() : List<Food>
    @Query("SELECT * FROM FOOD WHERE uuid = :FoodId")
    suspend fun getFood(FoodId : Int) : Food
    @Query("DELETE FROM FOOD")
    suspend fun deleteAllFoods()
}