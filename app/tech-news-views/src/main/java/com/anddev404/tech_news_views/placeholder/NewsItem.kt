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
            return arrayListOf(NewsItem("header 1"), NewsItem("header 2"), NewsItem("header 3"))
        }
    }

}
