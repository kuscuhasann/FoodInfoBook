package com.pakt_games.foodinfobook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.pakt_games.foodinfobook.R
import com.pakt_games.foodinfobook.adapter.FoodRecyclerAdapter
import com.pakt_games.foodinfobook.viewmodel.FoodListViewModel
import kotlinx.android.synthetic.main.fragment_food_list.*


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
        //Connecting fragment and ViewModel
        viewModel=ViewModelProviders.of(this).get(FoodListViewModel::class.java)
        viewModel.refleshData()
        //RecylerView
        foodListRecyclerViewId.layoutManager=LinearLayoutManager(context)
        foodListRecyclerViewId.adapter=recylerFoodAdapter

        swipeRefleshLayout.setOnRefreshListener {
            foodListFragmentProgressBarId.visibility=View.VISIBLE
            foodListRecyclerViewId.visibility=View.GONE
            foodListFragmentRecylerWarnMessageId.visibility=View.GONE
            viewModel.refleshData()
            swipeRefleshLayout.isRefreshing=false
        }
        observeLiveData()
    }

    //Control
    fun observeLiveData()
    {
        viewModel.foods.observe(viewLifecycleOwner, Observer { foods->
            foods?.let {
                foodListRecyclerViewId.visibility=View.VISIBLE
                recylerFoodAdapter.updateToFoodList(it)
            }
        })

        viewModel.foodWarnMessage.observe(viewLifecycleOwner, Observer { err->
            err?.let {
                if(it)
                {
                    foodListFragmentRecylerWarnMessageId.visibility=View.VISIBLE
                }
                else
                    foodListFragmentRecylerWarnMessageId.visibility=View.GONE
            }

        })
        viewModel.isFoodLoading.observe(viewLifecycleOwner, Observer { isLoading->
            isLoading?.let {
                if(it)
                {
                    foodListRecyclerViewId.visibility=View.GONE
                    foodListFragmentRecylerWarnMessageId.visibility=View.GONE
                    foodListFragmentProgressBarId.visibility=View.VISIBLE
                }
                else
                    foodListFragmentProgressBarId.visibility=View.GONE
            }

        })
    }


}