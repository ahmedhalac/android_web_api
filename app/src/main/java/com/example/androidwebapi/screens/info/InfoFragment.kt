package com.example.androidwebapi.screens.info

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.androidwebapi.R
import com.example.androidwebapi.database.MovieDatabase
import com.example.androidwebapi.database.MoviesEntity
import com.example.androidwebapi.databinding.FragmentDetailsBinding
import com.example.androidwebapi.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentInfoBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        val dataSource = MovieDatabase.getInstance(application).movieDatabaseDao

        val viewModelFactory = InfoViewModelFactory(dataSource, application)

        val infoViewModel = ViewModelProvider(
                this, viewModelFactory).get(InfoViewModel::class.java)


        binding.lifecycleOwner = this

        binding.infoViewModel = infoViewModel

        setHasOptionsMenu(true)

        return binding.root
    }


}