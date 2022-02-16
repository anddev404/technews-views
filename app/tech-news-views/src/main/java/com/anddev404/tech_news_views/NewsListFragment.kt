package com.anddev404.tech_news_views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anddev404.tech_news_views.placeholder.NewsItem

/**
 * A fragment representing a list of Items.
 */
class NewsListFragment : Fragment() {

    private var columnCount = 1
    private var newsList = arrayListOf<NewsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
            newsList = it.getParcelableArrayList<NewsItem>(ARG_NEWS_LIST) as ArrayList<NewsItem>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            changeLayoutManager(view)
        }
        return view
    }

    private fun changeLayoutManager(recyclerView: RecyclerView) {
        with(recyclerView) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }

        }
        recyclerView.adapter = NewsItemRecyclerViewAdapter(newsList)

    }

    fun setData(columnCount: Int, newsList: ArrayList<NewsItem>) {

        this.columnCount = columnCount
        this.newsList = newsList

        if (view is RecyclerView) {
            changeLayoutManager(view as RecyclerView)
        }
    }

    fun addItems(newsList: ArrayList<NewsItem>) {

        this.newsList.addAll(newsList)

        if (view is RecyclerView) {
            (view as RecyclerView).adapter?.notifyDataSetChanged()
        }
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"
        const val ARG_NEWS_LIST = "news-list"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int, newsList: ArrayList<NewsItem>) =
            NewsListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                    putParcelableArrayList(ARG_NEWS_LIST, newsList)
                }
            }
    }
}