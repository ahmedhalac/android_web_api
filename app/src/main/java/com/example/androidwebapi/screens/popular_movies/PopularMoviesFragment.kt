package com.example.androidwebapi.screens.popular_movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.androidwebapi.databinding.FragmentPopularMoviesBinding
import com.example.androidwebapi.databinding.GridViewItemBinding

class PopularMoviesFragment : Fragment() {

    private val viewModel: PopularMoviesViewModel by lazy {
        ViewModelProvider(this).get(PopularMoviesViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentPopularMoviesBinding.inflate(inflater)

        //val binding = GridViewItemBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.popularMoviesVM = viewModel

        setHasOptionsMenu(true)

        binding.photosGrid.adapter = PhotoGridAdapter()
        return binding.root

    }

}