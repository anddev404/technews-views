package com.anddev404.tech_news_views

import com.anddev404.tech_news_views.placeholder.NewsItem

interface OnNewsListFragmentListener {

    fun updateList(pageNumber: Int)
    fun tapItem(itemPosition: Int, newsItem: NewsItem)
    fun getImage(url: String, newsItem: NewsItem)

}