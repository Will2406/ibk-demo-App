package com.ibk.app.product.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibk.app.databinding.ItemMovementBinding
import com.ibk.app.product.domain.model.Account
import com.ibk.app.product.domain.model.Movement

class MovementAdapter : ListAdapter<Movement, MovementAdapter.ViewHolder>(AccountDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovementBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.bind(it)
        }
    }

    class ViewHolder(private val view: ItemMovementBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(movement: Movement) = with(view) {
            view.movement = movement
        }
    }

    class AccountDiffCallback : DiffUtil.ItemCallback<Movement>() {
        override fun areItemsTheSame(oldItem: Movement, newItem: Movement): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movement, newItem: Movement): Boolean {
            return oldItem == newItem
        }
    }
}