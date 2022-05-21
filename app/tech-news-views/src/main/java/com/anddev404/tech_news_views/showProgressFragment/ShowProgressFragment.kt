package com.anddev404.tech_news_views.showProgressFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anddev404.tech_news_views.R


class ShowProgressFragment : Fragment() {
    private val TAG = "TechNewsViews"
    private val CLASS_NAME = ShowProgressFragment::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.w(TAG, "onCreate: $CLASS_NAME")

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.w(TAG, "onCreateView: $CLASS_NAME")

        return inflater.inflate(R.layout.fragment_show_progress, container, false)
    }
}