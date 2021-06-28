package com.example.androidwebapi.screens.movies_overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.androidwebapi.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private val viewModel: MoviesViewModel by lazy {
        ViewModelProvider(this).get(MoviesViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentMoviesBinding.inflate(inflater)

        //val binding = GridViewItemBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.moviesViewModel = viewModel

        setHasOptionsMenu(true)

        binding.photosGrid.adapter = PhotoGridAdapter()
        return binding.root

    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        viewModel.updateFilter(
//            when (item.itemId) {
//                R.id.show_top_rated -> MoviesApiFilter.SHOW_TOP_RATED
//                else -> MoviesApiFilter.SHOW_UPCOMING
//            }
//        )
//        return true
//    }

}