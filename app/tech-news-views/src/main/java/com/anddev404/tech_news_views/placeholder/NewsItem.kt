package com.anddev404.tech_news_views.placeholder

class NewsItem(var header: String) {

    companion object {

        fun getEmptyItemList(): List<NewsItem> {
            return listOf()
        }

        fun getExampleItemList(): List<NewsItem> {
            return listOf(NewsItem("header 1"), NewsItem("header 2"), NewsItem("header 3"))
        }
    }

}
