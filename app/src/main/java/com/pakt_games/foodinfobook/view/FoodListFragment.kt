package com.pakt_games.foodinfobook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.pakt_games.foodinfobook.R
import com.pakt_games.foodinfobook.adapter.FoodRecyclerAdapter
import com.pakt_games.foodinfobook.viewmodel.FoodListViewModel


class FoodListFragment : Fragment() {

    private lateinit var viewModel:FoodListViewModel
    private var recylerFoodAdapter=FoodRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProviders.of(this).get(FoodListViewModel::class.java)
        viewModel.refleshData()


    }


}