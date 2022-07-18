package com.ibk.app.core

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibk.app.R

@BindingAdapter("submitList")
fun <T> RecyclerView.submitList(items: List<T>?) {
    val listAdapter = (adapter as? ListAdapter<T, *>)
    listAdapter?.submitList(items)
}

@BindingAdapter("validateColor")
fun TextView.validateColor(value: Boolean) {
    setTextColor(resources.getColor(if (value) R.color.green else R.color.red, null))
}
