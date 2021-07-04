package com.example.androidwebapi.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.androidwebapi.R
import com.example.androidwebapi.database.MovieDatabase
import com.example.androidwebapi.databinding.FragmentDetailsBinding
import com.example.androidwebapi.databinding.FragmentDetailsTvBinding

class DetailsTvFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsTvBinding.inflate(inflater)

        val application = requireNotNull(activity).application

        val tvShow = DetailsTvFragmentArgs.fromBundle(requireArguments()).selectedTvShow
        val viewModelFactory = DetailsTvViewModelFactory(tvShow, application)

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(DetailsTvViewModel::class.java)


        setHasOptionsMenu(true)
        binding.lifecycleOwner = this
        return binding.root
    }

}