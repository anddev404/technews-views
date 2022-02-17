package com.anddev404.technewsview

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.anddev404.tech_news_views.NewsListFragment
import com.anddev404.tech_news_views.OnNewsListFragmentListener
import com.anddev404.tech_news_views.placeholder.NewsItem


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsFragment1: NewsListFragment =
            NewsListFragment.newInstance(2, NewsItem.getLongExampleItemList())

        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragmentNewsView, newsFragment1).commit();

        newsFragment1.setOnNewsListFragmentListener(object : OnNewsListFragmentListener {
            override fun updateList(pageNumber: Int) {
                Log.d("MARCIN", "download page: $pageNumber");
                //newsFragment1.addItems(NewsItem.getShortExampleItemList())
            }

            override fun tapItem(itemPosition: Int, newsItem: NewsItem) {
                Log.d("MARCIN", "tap: $itemPosition");

            }


        })

        val newsFragment2 = supportFragmentManager.findFragmentById(R.id.staticFragmentNewsView)
        newsFragment2?.let {
            if (newsFragment2 is NewsListFragment) {
                with(newsFragment2) {
                    setData(4, NewsItem.getShortExampleItemList())
                }
            }
        }

        var button = findViewById<Button>(R.id.test_button)
        button.setOnClickListener({
            if (newsFragment1 is NewsListFragment) {
                newsFragment1.addItems(NewsItem.getShortExampleItemList())
            }
        })

    }
}
