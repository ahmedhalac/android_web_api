package com.example.androidwebapi.screens.movies_overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidwebapi.databinding.GridViewItemBinding
import com.example.androidwebapi.network.Movies


class PhotoGridAdapter( private val onClickListener: OnClickListener ): ListAdapter<Movies.Result,
        PhotoGridAdapter.MoviesPropertyViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesPropertyViewHolder {
        return MoviesPropertyViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MoviesPropertyViewHolder, position: Int) {
        val movie = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(movie)
        }
        holder.bind(movie)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Movies.Result>() {
        override fun areItemsTheSame(
            oldItem: Movies.Result,
            newItem: Movies.Result
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: Movies.Result,
            newItem: Movies.Result
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class MoviesPropertyViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieProperty: Movies.Result) {
            binding.property = movieProperty
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (movie:Movies.Result) -> Unit) {
        fun onClick(movie:Movies.Result) = clickListener(movie)
    }


}