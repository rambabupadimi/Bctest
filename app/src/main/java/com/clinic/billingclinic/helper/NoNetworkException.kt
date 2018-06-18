package com.clinic.billingclinic.helper

import android.content.Context
import com.clinic.billingclinic.R
import java.io.IOException


class NoNetworkException(context: Context) : IOException() {
    val mContext: Context = context

    override val message: String?
        get() = mContext.getString(R.string.no_internet)
}