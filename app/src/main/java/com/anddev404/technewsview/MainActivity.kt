package com.anddev404.technewsview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.anddev404.tech_news_views.NewsListFragment
import com.anddev404.tech_news_views.placeholder.NewsItem


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsFragment1: NewsListFragment =
            NewsListFragment.newInstance(2, NewsItem.getLongExampleItemList())

        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragmentNewsView, newsFragment1).commit();


        val newsFragment2 = supportFragmentManager.findFragmentById(R.id.staticFragmentNewsView)
        newsFragment2?.let {
            if (newsFragment2 is NewsListFragment) {
                with(newsFragment2) {
                    setData(4, NewsItem.getShortExampleItemList())
                }
            }
        }

    }
}
