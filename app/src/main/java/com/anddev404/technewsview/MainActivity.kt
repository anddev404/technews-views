package com.anddev404.technewsview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anddev404.tech_news_views.newsListFragment.NewsListFragment
import com.anddev404.tech_news_views.newsListFragment.model.NewsItem
import com.anddev404.tech_news_views.showNewsDetailsFragment.NewsDetailsFragment


class MainActivity : AppCompatActivity() {

    lateinit var list: NewsListFragment
    lateinit var details: NewsDetailsFragment

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        list =
            NewsListFragment.newInstance(1, NewsItem.getShortExampleItemList().toTypedArray())
        getSupportFragmentManager().beginTransaction()
            .add(R.id.fragmentNewsView, list).commit();

        details =
            NewsDetailsFragment.newInstance("https://www.gsmmaniak.pl/1302493/android-13-telefony-xiaomi-bez-aktualizacji/")
        getSupportFragmentManager().beginTransaction()
            .add(R.id.fragmentDetails, details).commit();
    }

}
