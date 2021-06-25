package com.example.androidwebapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var title: TextView

        init {
            title = itemView.findViewById(R.id.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layout_type = R.layout.list_item
        val view = LayoutInflater.from(parent.context).inflate(layout_type, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.title.text = "List Fragment Naslov"
    }
}