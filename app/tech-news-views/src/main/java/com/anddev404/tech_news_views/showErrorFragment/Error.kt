package com.anddev404.tech_news_views.showErrorFragment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Error(
    var errorText: String = "Unknown Error",
    var errorTextButton: String = "Ok",
    var errorCode: Int = 0
) : Parcelable {
}