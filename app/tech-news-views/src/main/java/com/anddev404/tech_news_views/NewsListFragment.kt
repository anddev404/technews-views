package com.anddev404.tech_news_views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anddev404.tech_news_views.placeholder.NewsItem
import com.anddev404.tech_news_views.tools.scrolling.OnScrollToEndListListener
import com.anddev404.tech_news_views.tools.scrolling.Scrolling

/**
 * A fragment representing a list of Items.
 */
class NewsListFragment : Fragment() {

    private var columnCount = 1
    private var newsList = arrayListOf<NewsItem>()
    private var scrolling: Scrolling? = null
    private var mListener: OnNewsListFragmentListener? = null
    private var pages = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
            newsList = ((it.getParcelableArray(ARG_NEWS_LIST)
                ?: arrayOf()) as Array<NewsItem>).toCollection(ArrayList())
            pages = it.getInt(ARG_PAGES)

            if (pages == 0) if (newsList.size > 0) pages = 1
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

            scrolling = Scrolling(object : OnScrollToEndListListener {
                override fun endOfList(downloadPage: Int) {
                    mListener?.updateList(downloadPage)
                }
            }, view, pages)

            (view.adapter as NewsItemRecyclerViewAdapter).setOnTapItemListener(
                object : NewsItemRecyclerViewAdapter.OnTapItemListener {
                    override fun tapItem(itemPosition: Int, newsItem: NewsItem) {
                        mListener?.tapItem(itemPosition, newsItem)
                    }

                    override fun setImage(url: String, newsItem: NewsItem, imageView: ImageView) {
                        mListener?.setImage(url, newsItem, imageView)
                    }
                })
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

    fun changeView(columnCount: Int) {
        this.columnCount = columnCount

        if (view is RecyclerView) {
            with(view as RecyclerView) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
            }
        }
    }

    fun addItems(newsList: ArrayList<NewsItem>) {
        scrolling?.downloadedNextPage()

        this.newsList.addAll(newsList)

        if (view is RecyclerView) {
            (view as RecyclerView).adapter?.notifyDataSetChanged()
        }
    }

//region: position of recyclerView

    fun getPositionFirstVisibleItem(): Int {

        if (view is RecyclerView) {
            return ((view as RecyclerView).layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
        }
        return 0
    }

    private fun getPositionLastVisibleItem(): Int {

        if (view is RecyclerView) {
            return ((view as RecyclerView).layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
        }
        return 0
    }

    fun scrollToPosition(positionToScroll: Int) {

        if (view is RecyclerView) {

            if (positionToScroll >= getPositionFirstVisibleItem()) {

                var visibleItemCount =
                    getPositionLastVisibleItem() - getPositionFirstVisibleItem()

                (view as RecyclerView).scrollToPosition(positionToScroll + visibleItemCount - columnCount)

            } else {
                (view as RecyclerView).scrollToPosition(positionToScroll)
            }


        }

    }

    //endregion

    fun setOnNewsListFragmentListener(onNewsListFragmentListener: OnNewsListFragmentListener?) {
        mListener = onNewsListFragmentListener
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"
        const val ARG_NEWS_LIST = "news-list"
        const val ARG_PAGES = "pages"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(
            columnCount: Int = 1,
            newsList: Array<NewsItem> = arrayOf(),
            pages: Int = 1
        ) =
            NewsListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                    putParcelableArray(ARG_NEWS_LIST, newsList)
                    putInt(ARG_PAGES, pages)

                }
            }
    }
}