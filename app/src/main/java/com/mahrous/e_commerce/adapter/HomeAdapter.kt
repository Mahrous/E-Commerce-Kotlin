package com.mahrous.e_commerce.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahrous.domain.entity.HomeModel
import com.mahrous.e_commerce.databinding.SingleRowHomeBinding


class HomeAdapter() : ListAdapter<HomeModel, HomeAdapter.ViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = SingleRowHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: SingleRowHomeBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(homeModel: HomeModel) {
            itemBinding.authorName.text = homeModel.auth
            itemBinding.bookName.text = homeModel.name
            Glide.with(itemBinding.root.context).load(homeModel.image).into(itemBinding.book)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<HomeModel>() {
        override fun areItemsTheSame(
            oldItem: HomeModel,
            newItem: HomeModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: HomeModel,
            newItem: HomeModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}