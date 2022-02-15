package com.anddev404.tech_news_views.placeholder

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class NewsItem(var header: String) : Parcelable {


    companion object {

        fun getEmptyItemList(): ArrayList<NewsItem> {
            return arrayListOf()
        }

        fun getExampleItemList(): ArrayList<NewsItem> {
            return arrayListOf(
                NewsItem("header 1"),
                NewsItem("header 2"),
                NewsItem("header 3"),
                NewsItem("header 4"),
                NewsItem("header 5"),
                NewsItem("header 6")
            )
        }

        fun getExampleItemList2(): ArrayList<NewsItem> {
            return arrayListOf(
                NewsItem("1. header"),
                NewsItem("2. header"),
                NewsItem("3. header"),
                NewsItem("4. header"),
                NewsItem("5. header"),
                NewsItem("6. header")
            )
        }
    }

}
