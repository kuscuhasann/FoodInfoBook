package com.pakt_games.foodinfobook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pakt_games.foodinfobook.R
import com.pakt_games.foodinfobook.databinding.FragmentFoodDetailBinding
import com.pakt_games.foodinfobook.util.createPlaceholder
import com.pakt_games.foodinfobook.util.downloadImage
import com.pakt_games.foodinfobook.viewmodel.FoodDetailViewModel
import com.pakt_games.foodinfobook.viewmodel.FoodListViewModel
import kotlinx.android.synthetic.main.fragment_food_detail.*

class FoodDetailFragment : Fragment() {
    private  lateinit var viewModel: FoodDetailViewModel
    private var foodId=0
    private lateinit var databinding: FragmentFoodDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding=DataBindingUtil.inflate(inflater,R.layout.fragment_food_detail,container,false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            foodId=FoodDetailFragmentArgs.fromBundle(it).foodId
        }

        viewModel= ViewModelProviders.of(this).get(FoodDetailViewModel::class.java)
        viewModel.getRoomData(foodId)
        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.foodLiveData.observe(viewLifecycleOwner, Observer {food->
            food?.let {
                databinding.model=it
            }
        })
    }


}