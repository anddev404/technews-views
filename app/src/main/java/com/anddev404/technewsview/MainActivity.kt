package com.anddev404.technewsview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anddev404.tech_news_views.NewsListFragment
import com.anddev404.tech_news_views.placeholder.NewsItem


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsFragment1: NewsListFragment =
            NewsListFragment.newInstance(2, NewsItem.getExampleItemList())

        getSupportFragmentManager().beginTransaction()
            .add(R.id.fragmentNewsView, newsFragment1).commit();

    }
}
