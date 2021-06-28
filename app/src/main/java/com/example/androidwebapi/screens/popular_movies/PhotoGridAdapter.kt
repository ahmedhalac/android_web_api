package com.example.androidwebapi.screens.popular_movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidwebapi.databinding.GridViewItemBinding
import com.example.androidwebapi.network.PopularMovies


class PhotoGridAdapter : ListAdapter<PopularMovies.Result,
        PhotoGridAdapter.MoviesPropertyViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.MoviesPropertyViewHolder {
        return MoviesPropertyViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.MoviesPropertyViewHolder, position: Int) {
        val movieProperty = getItem(position)
        holder.bind(movieProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PopularMovies.Result>() {
        override fun areItemsTheSame(
            oldItem: PopularMovies.Result,
            newItem: PopularMovies.Result
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: PopularMovies.Result,
            newItem: PopularMovies.Result
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class MoviesPropertyViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieProperty: PopularMovies.Result) {
            binding.property = movieProperty
            binding.executePendingBindings()
        }
    }


}
