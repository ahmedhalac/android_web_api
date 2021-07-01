package com.example.androidwebapi.screens.details

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.androidwebapi.R
import com.example.androidwebapi.database.MovieDatabase
import com.example.androidwebapi.databinding.FragmentDetailsBinding
import com.example.androidwebapi.network.Movies

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDetailsBinding.inflate(inflater)

        val application = requireNotNull(activity).application
        val dataSource = MovieDatabase.getInstance(application).movieDatabaseDao


        val movie = DetailsFragmentArgs.fromBundle(requireArguments()).selectedMovie
        val viewModelFactory = DetailsViewModelFactory(dataSource, movie, application)

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(DetailsViewModel::class.java)

        binding.moreDetails.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_detailsFragment_to_infoFragment)
        }

        val detailsViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(DetailsViewModel::class.java)

        setHasOptionsMenu(true)
        binding.lifecycleOwner = this
        binding.moviesViewModel = detailsViewModel
        return binding.root
    }

    // Creating our Share Intent
    private fun getShareIntent() : Intent {
        val args = DetailsFragmentArgs.fromBundle(requireArguments()).selectedMovie
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/*")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_movie_details_text, args))
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    // Showing the Share Menu Item Dynamically
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.summary_menu, menu)
        if(getShareIntent().resolveActivity(requireActivity().packageManager)==null){
            menu.findItem(R.id.share).isVisible = false
        }
    }

    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }



}