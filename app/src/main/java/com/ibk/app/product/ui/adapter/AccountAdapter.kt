package com.ibk.app.product.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibk.app.databinding.ItemAccountBinding
import com.ibk.app.product.domain.model.Account

class AccountAdapter : ListAdapter<Account, AccountAdapter.ViewHolder>(AccountDiffCallback()) {

    var listener: AccountListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAccountBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.bind(it, listener)
        }
    }

    class ViewHolder(private val view: ItemAccountBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(account: Account, listener: AccountListener?) = with(view) {
            view.account = account
            view.layoutContainer.setOnClickListener { listener?.goToDetail(account) }
        }
    }

    class AccountDiffCallback : DiffUtil.ItemCallback<Account>() {
        override fun areItemsTheSame(oldItem: Account, newItem: Account): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Account, newItem: Account): Boolean {
            return oldItem == newItem
        }
    }


}

interface AccountListener {
    fun goToDetail(account: Account)
}


