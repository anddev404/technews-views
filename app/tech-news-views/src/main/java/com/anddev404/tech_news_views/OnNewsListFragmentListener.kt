package com.anddev404.tech_news_views

import android.widget.ImageView
import com.anddev404.tech_news_views.placeholder.NewsItem

interface OnNewsListFragmentListener {

    fun updateList()
    fun tapItem(itemPosition: Int, newsItem: NewsItem)
    fun setImage(url: String, newsItem: NewsItem, imageView: ImageView)

}