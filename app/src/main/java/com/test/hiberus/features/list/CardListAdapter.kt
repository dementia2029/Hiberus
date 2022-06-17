package com.test.hiberus.features.list

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.hiberus.R
import com.test.hiberus.data.source.remote.retrofit.model.Card
import com.test.hiberus.domain.model.CardData
import com.test.hiberus.utils.GlideApp

class CardListAdapter(val clickListener: (id: String) -> Unit) : ListAdapter<CardData, CardListAdapter.CardViewHolder>(
    object : DiffUtil.ItemCallback<CardData>() {
        override fun areItemsTheSame(oldItem: CardData, newItem: CardData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CardData, newItem: CardData) = true
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_card_item,
                parent, false)
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        GlideApp
            .with(holder.itemView)
            .load(getItem(position).imageUrl)
            .placeholder(ColorDrawable(holder.itemView.resources.getColor(R.color.purple_200)))
            .into(holder.img)
        holder.textView.text = getItem(position).name
    }

    inner class CardViewHolder(binding: View) : RecyclerView.ViewHolder(binding) {
        val img : ImageView = binding.findViewById(R.id.img)
        val textView: TextView = binding.findViewById(R.id.textview)

        init {
            binding.setOnClickListener(){
                clickListener(getItem(adapterPosition).id)
            }
        }
    }
}