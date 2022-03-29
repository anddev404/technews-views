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
    private var positionToScroll = 0
    private var scrolling: Scrolling? = null
    private var mListener: OnNewsListFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
            newsList = ((it.getParcelableArray(ARG_NEWS_LIST)
                ?: arrayOf()) as Array<NewsItem>).toCollection(ArrayList())
            positionToScroll = it.getInt(ARG_POSITION_TO_SCROLL)
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
                override fun endOfList() {
                    mListener?.updateList()
                }
            }, view)

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (positionToScroll > 0) scrollToPosition(positionToScroll)
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

        scrolling?.unlockListenerAfterUpdateList()

        this.newsList.addAll(newsList)

        if (view is RecyclerView) {
            (view as RecyclerView).adapter?.notifyDataSetChanged()
        }
    }

//region: position of recyclerView

    fun getFirstVisibleItemPosition(): Int {

        if (view is RecyclerView) {
            return ((view as RecyclerView).layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
        }
        return 0
    }

    private fun getLastItemPosition(): Int {

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

                var newPositionToScroll = positionToScroll + visibleItemCount - columnCount

                if (newPositionToScroll > (view as RecyclerView).adapter?.itemCount ?: 0) {
                    newPositionToScroll =
                        (view as RecyclerView).adapter?.itemCount ?: 0
                    newPositionToScroll = newPositionToScroll - 1
                    (view as RecyclerView).scrollToPosition(newPositionToScroll)
                } else {
                    (view as RecyclerView).scrollToPosition(newPositionToScroll)

                }

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
        const val ARG_POSITION_TO_SCROLL = "position"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(
            columnCount: Int = 1,
            newsList: Array<NewsItem> = arrayOf(),
            scrollToPosition: Int = 0
        ) =
            NewsListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                    putParcelableArray(ARG_NEWS_LIST, newsList)
                    putInt(ARG_POSITION_TO_SCROLL, scrollToPosition)
                }
            }
    }
}