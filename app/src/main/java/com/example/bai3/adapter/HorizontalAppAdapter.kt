package com.example.bai3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.bai3.R
import com.example.bai3.databinding.LayoutAppHorizontalItemBinding
import com.example.bai3.model.AppItem

class HorizontalAppAdapter(
    private val apps: List<AppItem>
) : RecyclerView.Adapter<HorizontalAppAdapter.HorizontalAppViewHolder>() {

    class HorizontalAppViewHolder(private val binding: LayoutAppHorizontalItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(app: AppItem) {
            // Dùng Coil để tải ảnh từ URL
            binding.horizontalAppIcon.load(app.imageUrl) {
                crossfade(true)
                placeholder(R.drawable.ic_placeholder)
                error(R.drawable.ic_placeholder)
            }
            binding.horizontalAppName.text = app.name
            binding.horizontalAppRating.text = app.rating.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalAppViewHolder {
        val binding = LayoutAppHorizontalItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HorizontalAppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HorizontalAppViewHolder, position: Int) {
        holder.bind(apps[position])
    }

    override fun getItemCount() = apps.size
}
