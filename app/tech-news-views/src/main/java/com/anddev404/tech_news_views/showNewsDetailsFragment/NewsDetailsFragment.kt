package com.anddev404.tech_news_views.showNewsDetailsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.anddev404.tech_news_views.R


private const val ARG_URL = "url"

class NewsDetailsFragment : Fragment() {

    private var url: String = ""
    private lateinit var webView: WebView
    private lateinit var refereshLayout: SwipeRefreshLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(ARG_URL) ?: url
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_news_details, container, false)

        webView = view.findViewById(R.id.news_details_web_view)
        configureWebView()

        refereshLayout = view.findViewById(R.id.refresh_layout)
        setOnRefereshLayoutListener()

        webView.loadUrl(url)
        return view
    }

    fun setOnRefereshLayoutListener() {
        refereshLayout.setOnRefreshListener {
            webView.loadUrl(webView.url.toString())
            refereshLayout.isRefreshing = false
        }
    }

    private fun configureWebView() {
        webView.settings.javaScriptEnabled = true
        webView.setWebViewClient(WebViewClient())
    }

    fun goBack(): Boolean {
        if (webView.canGoBack()) {
            webView.goBack();
            return true
        }
        return false
    }

    fun setBundle(url: String) {
        arguments = Bundle().apply {
            putString(ARG_URL, url)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(url: String) =
            NewsDetailsFragment().apply {
                setBundle(url)
            }
    }
}