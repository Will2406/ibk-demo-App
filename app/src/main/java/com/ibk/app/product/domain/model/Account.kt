package com.ibk.app.product.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Account(
    var id: Int,
    var type: String,
    var amount: String,
    var number: String
) : Parcelable