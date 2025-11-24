package com.example.bai3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bai3.databinding.LayoutSectionContainerBinding // Đảm bảo import đúng
import com.example.bai3.model.PlayStoreSection
import com.example.bai3.model.SectionType

class MainSectionAdapter(
    private val sections: List<PlayStoreSection>
) : RecyclerView.Adapter<MainSectionAdapter.SectionViewHolder>() {

    class SectionViewHolder(private val binding: LayoutSectionContainerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(section: PlayStoreSection) {
            binding.sectionTitleText.text = section.title

            when (section.viewType) {
                // Section dọc nhóm 3 (Suggested for you) - CUỘN NGANG THEO NHÓM
                SectionType.VERTICAL_GROUP -> {
                    // Chia apps thành các nhóm 3
                    val groups = section.apps.chunked(3)

                    binding.sectionAppsRecycler.layoutManager = LinearLayoutManager(
                        itemView.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    binding.sectionAppsRecycler.adapter = GroupThreeAdapter(groups)

                    binding.sectionArrowButton.visibility = View.GONE
                    binding.sectionMoreIcon.visibility = View.VISIBLE
                    binding.sectionAppsRecycler.setPadding(8, 0, 8, 0)
                }

                // Section cuộn ngang (Recommended for you)
                SectionType.HORIZONTAL_SCROLL -> {
                    binding.sectionAppsRecycler.layoutManager = LinearLayoutManager(
                        itemView.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    binding.sectionAppsRecycler.adapter = HorizontalAppAdapter(section.apps)
                    binding.sectionArrowButton.visibility = View.VISIBLE
                    binding.sectionMoreIcon.visibility = View.VISIBLE
                    binding.sectionAppsRecycler.setPadding(8, 0, 8, 0)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val binding = LayoutSectionContainerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(sections[position])
    }

    override fun getItemCount() = sections.size
}
