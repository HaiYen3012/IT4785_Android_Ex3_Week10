package com.example.bai3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.bai3.R
import com.example.bai3.model.AppItem

class GroupThreeAdapter(private val groups: List<List<AppItem>>) :
    RecyclerView.Adapter<GroupThreeAdapter.GroupViewHolder>() {

    inner class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // App 1
        val icon1: ImageView = itemView.findViewById(R.id.icon1)
        val name1: TextView = itemView.findViewById(R.id.name1)
        val category1: TextView = itemView.findViewById(R.id.category1)
        val rating1: TextView = itemView.findViewById(R.id.rating1)
        val size1: TextView = itemView.findViewById(R.id.size1)

        // App 2
        val icon2: ImageView = itemView.findViewById(R.id.icon2)
        val name2: TextView = itemView.findViewById(R.id.name2)
        val category2: TextView = itemView.findViewById(R.id.category2)
        val rating2: TextView = itemView.findViewById(R.id.rating2)
        val size2: TextView = itemView.findViewById(R.id.size2)

        // App 3
        val icon3: ImageView = itemView.findViewById(R.id.icon3)
        val name3: TextView = itemView.findViewById(R.id.name3)
        val category3: TextView = itemView.findViewById(R.id.category3)
        val rating3: TextView = itemView.findViewById(R.id.rating3)
        val size3: TextView = itemView.findViewById(R.id.size3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_group_three_vertical, parent, false)
        return GroupViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val group = groups[position]

        fun bindApp(
            app: AppItem?,
            icon: ImageView,
            name: TextView,
            category: TextView,
            rating: TextView,
            size: TextView
        ) {
            if (app != null) {
                icon.load(app.imageUrl) {
                    crossfade(true)
                    placeholder(R.drawable.ic_placeholder)
                    error(R.drawable.ic_placeholder)
                }
                name.text = app.name
                category.text = app.category
                rating.text = app.rating.toString()
                size.text = app.size

                icon.visibility = View.VISIBLE
                name.visibility = View.VISIBLE
                category.visibility = View.VISIBLE
                rating.visibility = View.VISIBLE
                size.visibility = View.VISIBLE
            } else {
                // Ẩn nếu không có app
                icon.visibility = View.INVISIBLE
                name.visibility = View.INVISIBLE
                category.visibility = View.INVISIBLE
                rating.visibility = View.INVISIBLE
                size.visibility = View.INVISIBLE
            }
        }

        // Bind 3 apps
        bindApp(group.getOrNull(0), holder.icon1, holder.name1, holder.category1, holder.rating1, holder.size1)
        bindApp(group.getOrNull(1), holder.icon2, holder.name2, holder.category2, holder.rating2, holder.size2)
        bindApp(group.getOrNull(2), holder.icon3, holder.name3, holder.category3, holder.rating3, holder.size3)
    }

    override fun getItemCount() = groups.size
}
