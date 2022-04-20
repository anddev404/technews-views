package com.anddev404.technewsview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anddev404.tech_news_views.showNewsDetailsFragment.NewsDetailsFragment


class MainActivity : AppCompatActivity() {

    lateinit var details: NewsDetailsFragment

    override

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        details =
            NewsDetailsFragment.newInstance("https://www.gsmmaniak.pl/1302493/android-13-telefony-xiaomi-bez-aktualizacji/")

        getSupportFragmentManager().beginTransaction()
            .add(R.id.fragmentNewsView, details).commit();

    }

    override fun onBackPressed() {
        details.goBack()
    }
    //  super.onBackPressed()

}
