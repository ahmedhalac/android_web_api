package com.example.androidwebapi.screens.tv_shows


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidwebapi.databinding.GridViewItemTvShowsBinding
import com.example.androidwebapi.network.TvShows


class PhotoGridAdapterII ( private val onClickListener: OnClickListener): ListAdapter<TvShows.Result,
        PhotoGridAdapterII.TvShowsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowsViewHolder {
        return TvShowsViewHolder(GridViewItemTvShowsBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val tvShows = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(tvShows)
        }
        holder.bind(tvShows)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<TvShows.Result>() {
        override fun areItemsTheSame(oldItem: TvShows.Result, newItem: TvShows.Result): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TvShows.Result, newItem: TvShows.Result): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class TvShowsViewHolder(private var binding: GridViewItemTvShowsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShows.Result) {
            binding.property = tvShows
            binding.executePendingBindings()
        }

    }

    class OnClickListener(val clickListener: (tvShow:TvShows.Result) -> Unit) {
        fun onClick(tvShow:TvShows.Result) = clickListener(tvShow)
    }
}