package com.anddev404.tech_news_views.placeholder

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class NewsItem(var header: String, var imageUrl: String) : Parcelable {


    companion object {

        fun getEmptyItemList(): ArrayList<NewsItem> {
            return arrayListOf()
        }

        fun getLongExampleItemList(): ArrayList<NewsItem> {

            val exampleListOfItems = ArrayList<NewsItem>()
            for (i in 0..100) {
                exampleListOfItems.add(
                    NewsItem(
                        "header $i",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                    )
                )
            }
            return exampleListOfItems
        }

        fun getShortExampleItemList(): ArrayList<NewsItem> {
            return arrayListOf(
                NewsItem(
                    "1. header",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "2. header",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "3. header",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "4. header",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "5. header",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "6. header",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                )
            )
        }
    }

}
