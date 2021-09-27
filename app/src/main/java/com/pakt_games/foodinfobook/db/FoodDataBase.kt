package com.pakt_games.foodinfobook.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pakt_games.foodinfobook.model.Food

@Database(entities = arrayOf(Food::class) , version = 1)
abstract class FoodDataBase: RoomDatabase() {

    abstract fun foodDAO() :FoodDAO

    companion object{
        //Volatile= if you want using instance in all project
        @Volatile private var instance: FoodDataBase?=null

        private val lock = Any()
        //Basic Singleton
        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: createDatabase(context).also {
                instance=it
            }
        }
        //Creating Database
        private fun createDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            FoodDataBase::class.java, "foodDataBase").build()
    }

}