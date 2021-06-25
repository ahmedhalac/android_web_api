package com.example.androidwebapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidwebapi.R
import com.example.androidwebapi.databinding.FragmentAboutBinding
import com.example.androidwebapi.databinding.FragmentSelectBinding


class SelectFragment : Fragment(R.layout.fragment_select) {

    private var _binding: FragmentSelectBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.button.setOnClickListener {
            val action = SelectFragmentDirections.actionSelectFragmentToListFragment()
            findNavController().navigate(action)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}