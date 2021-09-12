package com.pakt_games.foodinfobook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.pakt_games.foodinfobook.R
import kotlinx.android.synthetic.main.fragment_food_detail.*

class FoodDetailFragment : Fragment() {

    private var foodId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Get arguments
        arguments?.let {
            foodId=FoodDetailFragmentArgs.fromBundle(it).foodId
            println("FOOD ID: "+ foodId)
        }

        button_food_detail_id.setOnClickListener {
            detailFragmentToListFragment(it)
        }
    }

        private fun detailFragmentToListFragment(view: View) {
            val action =FoodDetailFragmentDirections.actionFoodDetailFragmentToFoodListFragment()
            Navigation.findNavController(view).navigate(action)
        }
}