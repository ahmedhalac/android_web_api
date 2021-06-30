package com.example.androidwebapi.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.androidwebapi.R
import com.example.androidwebapi.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val movie = DetailsFragmentArgs.fromBundle(requireArguments()).selectedMovie
        val viewModelFactory = DetailsViewModelFactory(movie, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(DetailsViewModel::class.java)

        return binding.root
    }

}