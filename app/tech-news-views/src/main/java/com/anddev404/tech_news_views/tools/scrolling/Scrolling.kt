package com.anddev404.tech_news_views.tools.scrolling

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Scrolling(
    onScrollToEndListListeener: OnScrollToEndListListener,
    val recyclerView: RecyclerView,
    var showedPage: Int = 1
) {

    private var waitingForNewData = false
    private var onScrollToEndListListener: OnScrollToEndListListener? = null

    init {
        this.onScrollToEndListListener = onScrollToEndListListeener

        recyclerView.setOnScrollListener(object : RecyclerView.OnScrollListener() {

            val linearLayoutManager: LinearLayoutManager? =
                recyclerView.getLayoutManager() as LinearLayoutManager

            var totalItemCount = 0
            var lastVisibleItem = 0
            var visibleThreshold = 10

            override fun onScrolled(
                recyclerView: RecyclerView, dx: Int, dy: Int
            ) {
                super.onScrolled(recyclerView, dx, dy)

                totalItemCount = linearLayoutManager?.itemCount ?: 0
                lastVisibleItem = linearLayoutManager?.findLastVisibleItemPosition() ?: 0
                if (!waitingForNewData && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    waitingForNewData = true
                    showedPage++
                    onScrollToEndListListeener?.endOfList(showedPage)

                }
            }

        })
    }

    fun downloadedNextPage() {
        waitingForNewData = false
    }

}