package com.bikincerdas.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bikincerdas.core.R
import com.bikincerdas.core.databinding.ItemListRestaurantBinding
import com.bikincerdas.core.domain.model.Restaurant
import com.bumptech.glide.Glide
import java.util.ArrayList

class RestaurantAdapter : RecyclerView.Adapter<RestaurantAdapter.ListViewHolder>() {

    private var listData = ArrayList<Restaurant>()
    var onItemClick: ((Restaurant) -> Unit)? = null

    fun setData(newListData: List<Restaurant>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_restaurant, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListRestaurantBinding.bind(itemView)
        fun bind(data: Restaurant) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.pictureId)
                    .into(ivItemImage)
                tvItemName.text = data.name
                tvItemCity.text = data.city
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}