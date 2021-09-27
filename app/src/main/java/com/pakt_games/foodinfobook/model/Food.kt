package com.pakt_games.foodinfobook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Food(
    @ColumnInfo(name = "isim")
    @SerializedName("isim")
    val foodName:String?,
    @ColumnInfo(name = "kalori")
    @SerializedName("kalori")
    val foodCalorie:String?,
    @ColumnInfo(name = "karbonhidrat")
    @SerializedName("karbonhidrat")
    val foodCarbohydrate:String?,
    @ColumnInfo(name = "protein")
    @SerializedName("protein")
    val foodProtein:String?,
    @ColumnInfo(name = "yag")
    @SerializedName("yag")
    val foodFat:String?,
    @ColumnInfo(name = "gorsel")
    @SerializedName("gorsel")
    val foodImage:String?

)
