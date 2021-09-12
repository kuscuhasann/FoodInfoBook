package com.pakt_games.foodinfobook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.pakt_games.foodinfobook.R
import kotlinx.android.synthetic.main.fragment_food_list.*


class FoodListFragment : Fragment() {


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
        //button click in ListFragment
        button_food_list_id.setOnClickListener {
            listFragmentToDetailFragment(it)
        }

    }
    //Fragment to Fragment
    fun listFragmentToDetailFragment(view: View)
    {
        val action =FoodListFragmentDirections.actionFoodListFragmentToFoodDetailFragment(3)
        Navigation.findNavController(view).navigate(action)
    }
}