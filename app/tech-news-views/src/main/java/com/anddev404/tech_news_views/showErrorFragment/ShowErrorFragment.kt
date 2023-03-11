package com.anddev404.tech_news_views.showErrorFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.anddev404.tech_news_views.R

private const val ARG_PARAM1 = "errorText"

class ShowErrorFragment : Fragment() {
    private val TAG = "TechNewsViews"
    private val CLASS_NAME = ShowErrorFragment::class.simpleName

    private var error = Error()

    private lateinit var errorTextView: TextView
    private lateinit var errorButton: Button

    private var mListener: OnShowErrorFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.w(TAG, "onCreate: $CLASS_NAME")

        arguments?.let {
            error = it.getParcelable<Error>(ARG_PARAM1) ?: Error()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.w(TAG, "onCreateView: $CLASS_NAME")

        return inflater.inflate(R.layout.fragment_show_error, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
        setButtonClickListener()
        setTextToViews()
    }

    private fun initializeViews() {
        errorTextView = requireView().findViewById(R.id.errorText)
        errorButton = requireView().findViewById(R.id.errorButton)
    }

    private fun setButtonClickListener() {
        errorButton.setOnClickListener {
            mListener?.clickedErrorButton(error)
        }
    }

    private fun setTextToViews() {
        errorTextView.text = error.errorText
        errorButton.text = error.errorTextButton
    }

    companion object {

        @JvmStatic
        fun newInstance(error: Error = Error()) =
            ShowErrorFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, error)
                }
            }
    }


    fun setOnShowErrorFragmentListener(onShowErrorFragmentListener: OnShowErrorFragmentListener?) {
        mListener = onShowErrorFragmentListener
    }
}