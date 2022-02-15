package com.anddev404.tech_news_views.placeholder

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class NewsItem(var header: String) : Parcelable {


    companion object {

        fun getEmptyItemList(): ArrayList<NewsItem> {
            return arrayListOf()
        }

        fun getLongExampleItemList(): ArrayList<NewsItem> {

            val exampleListOfItems = ArrayList<NewsItem>()
            for (i in 0..100) {
                exampleListOfItems.add(NewsItem("header $i"))
            }
            return exampleListOfItems
        }

        fun getShortExampleItemList(): ArrayList<NewsItem> {
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
