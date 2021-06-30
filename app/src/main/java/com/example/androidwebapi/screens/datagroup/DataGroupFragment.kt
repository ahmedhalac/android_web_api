package com.example.androidwebapi.screens.datagroup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.androidwebapi.R
import com.example.androidwebapi.databinding.FragmentDataGroupBinding
import com.example.androidwebapi.databinding.FragmentIntroBinding

class DataGroupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDataGroupBinding>(
            inflater,
            R.layout.fragment_data_group,
            container,
            false
        )


        binding.popularMoviesBtn.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_dataGroupFragment_to_moviesFragment)
        }

        return binding.root
    }


}