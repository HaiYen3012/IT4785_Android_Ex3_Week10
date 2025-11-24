package com.example.bai3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.bai3.R
import com.example.bai3.databinding.LayoutAppVerticalItemBinding
import com.example.bai3.model.AppItem

class VerticalAppAdapter(
    private val apps: List<AppItem>
) : RecyclerView.Adapter<VerticalAppAdapter.VerticalAppViewHolder>() {

    class VerticalAppViewHolder(private val binding: LayoutAppVerticalItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(app: AppItem) {
            binding.verticalAppIcon.load(app.imageUrl) {
                crossfade(true)
                placeholder(R.drawable.ic_placeholder)
                error(R.drawable.ic_placeholder)
            }
            binding.verticalAppName.text = app.name
            binding.verticalAppCategory.text = app.category
            binding.verticalAppRating.text = app.rating.toString()
            binding.verticalAppSize.text = app.size
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalAppViewHolder {
        val binding = LayoutAppVerticalItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VerticalAppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VerticalAppViewHolder, position: Int) {
        holder.bind(apps[position])
    }

    override fun getItemCount() = apps.size
}
