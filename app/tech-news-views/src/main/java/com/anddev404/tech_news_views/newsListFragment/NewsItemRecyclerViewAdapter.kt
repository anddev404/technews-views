package com.anddev404.tech_news_views.newsListFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.anddev404.tech_news_views.R
import com.anddev404.tech_news_views.databinding.FragmentNewsItemBinding
import com.anddev404.tech_news_views.newsListFragment.model.NewsItem
import java.net.URL

class NewsItemRecyclerViewAdapter(
    private val values: List<NewsItem>
) : RecyclerView.Adapter<NewsItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentNewsItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.header
        try {
            holder.websiteName.text = URL(item.siteUrl).host
        } catch (t: Throwable) {
        }
        holder.view.setOnClickListener {
            mListener?.tapItem(position, values[position]);
        }
        holder.favouriteButton.setOnClickListener {
            Toast.makeText(
                holder.favouriteButton.context,
                holder.favouriteButton.context.getString(R.string.not_implemented_yet),
                Toast.LENGTH_LONG
            ).show()
        }

        mListener?.setImage(values[position].imageUrl, values[position], holder.imageView)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentNewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val view: View = binding.allView
        val title: TextView = binding.itemHeader
        val websiteName: TextView = binding.websiteName
        val imageView: ImageView = binding.itemImageView
        val favouriteButton: ImageView = binding.favouriteImageview

        override fun toString(): String {
            return super.toString() + " '" + title.text + "'"
        }
    }

    private var mListener: OnTapItemListener? = null

    fun setOnTapItemListener(onTapItemListener: OnTapItemListener) {
        mListener = onTapItemListener

    }

    interface OnTapItemListener {
        fun tapItem(itemPosition: Int, newsItem: NewsItem)
        fun setImage(url: String, newsItem: NewsItem, imageView: ImageView)

    }

}