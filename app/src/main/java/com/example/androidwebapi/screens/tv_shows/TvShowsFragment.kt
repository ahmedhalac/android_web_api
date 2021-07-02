package com.example.androidwebapi.screens.tv_shows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.androidwebapi.R
import com.example.androidwebapi.databinding.FragmentTvShowsBinding
import com.example.androidwebapi.databinding.GridViewItemTvShowsBinding

class TvShowsFragment : Fragment() {

    private val viewModel: TvShowsViewModel by lazy {
        ViewModelProvider(this).get(TvShowsViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentTvShowsBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        binding.tvViewModel = viewModel
        setHasOptionsMenu(true)
        binding.photosGrid.adapter = PhotoGridAdapterII(PhotoGridAdapterII.OnClickListener {
            viewModel.displayTvShowDetails(it)
        })

        viewModel.navigateToSelectedTvShow.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(
                    TvShowsFragmentDirections.actionShowTVDetails(it))
                viewModel.displayTvShowDetailsComplete()
            }
        })
        return binding.root
    }

}