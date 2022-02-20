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
                    "Apple Watch 7",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Pegasus spyware scandal uncovered by fake image file on an iPhone",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "Warning you could be MORE at risk of being tracked with Apple AirTags if yopu don't use specific proiduct, expert reveals",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Apple Watch 7",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Pegasus spyware scandal uncovered by fake image file on an iPhone",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "Warning you could be MORE at risk of being tracked with Apple AirTags if yopu don't use specific proiduct, expert reveals",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Apple Watch 7",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Pegasus spyware scandal uncovered by fake image file on an iPhone",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "Warning you could be MORE at risk of being tracked with Apple AirTags if yopu don't use specific proiduct, expert reveals",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Apple Watch 7",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Pegasus spyware scandal uncovered by fake image file on an iPhone",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "Warning you could be MORE at risk of being tracked with Apple AirTags if yopu don't use specific proiduct, expert reveals",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Apple Watch 7",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Pegasus spyware scandal uncovered by fake image file on an iPhone",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "Warning you could be MORE at risk of being tracked with Apple AirTags if yopu don't use specific proiduct, expert reveals",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Apple Watch 7",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Pegasus spyware scandal uncovered by fake image file on an iPhone",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "Warning you could be MORE at risk of being tracked with Apple AirTags if yopu don't use specific proiduct, expert reveals",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Apple Watch 7",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Pegasus spyware scandal uncovered by fake image file on an iPhone",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "Warning you could be MORE at risk of being tracked with Apple AirTags if yopu don't use specific proiduct, expert reveals",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Apple Watch 7",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Pegasus spyware scandal uncovered by fake image file on an iPhone",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "Warning you could be MORE at risk of being tracked with Apple AirTags if yopu don't use specific proiduct, expert reveals",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Apple Watch 7",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Pegasus spyware scandal uncovered by fake image file on an iPhone",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "Warning you could be MORE at risk of being tracked with Apple AirTags if yopu don't use specific proiduct, expert reveals",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Apple Watch 7",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Pegasus spyware scandal uncovered by fake image file on an iPhone",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "Warning you could be MORE at risk of being tracked with Apple AirTags if yopu don't use specific proiduct, expert reveals",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Apple Watch 7",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
                NewsItem(
                    "Pegasus spyware scandal uncovered by fake image file on an iPhone",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDu726oeFoAfkD5EpO-s2rzc8y1Wo_TClKFA&usqp=CAU"
                ),
                NewsItem(
                    "Warning you could be MORE at risk of being tracked with Apple AirTags if yopu don't use specific proiduct, expert reveals",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR563zwATHZ8pvggtUl0sQc5OgQxFL3GoJcLg&usqp=CAU"
                ),
            )
        }
    }

}
