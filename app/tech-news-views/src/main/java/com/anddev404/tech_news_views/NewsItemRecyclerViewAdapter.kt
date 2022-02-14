package com.anddev404.tech_news_views

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anddev404.tech_news_views.databinding.FragmentNewsItemBinding
import com.anddev404.tech_news_views.placeholder.NewsItem

class NewsItemRecyclerViewAdapter(
    private val values: List<NewsItem>
) : RecyclerView.Adapter<NewsItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentNewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.header
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentNewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemHeader

        override fun toString(): String {
            return super.toString() + " '" + idView.text + "'"
        }
    }

}