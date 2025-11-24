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
                // Section dọc (Suggested for you)
                SectionType.VERTICAL_GROUP -> {
                    binding.sectionAppsRecycler.layoutManager = LinearLayoutManager(itemView.context)
                    binding.sectionAppsRecycler.adapter = VerticalAppAdapter(section.apps)

                    // Với section dọc, không cần mũi tên chuyển tiếp ở cuối
                    binding.sectionArrowButton.visibility = View.GONE

                    // Icon 3 chấm luôn hiển thị theo layout mới
                    binding.sectionMoreIcon.visibility = View.VISIBLE
                }

                // Section cuộn ngang (Recommended for you)
                SectionType.HORIZONTAL_SCROLL -> {
                    binding.sectionAppsRecycler.layoutManager = LinearLayoutManager(
                        itemView.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    binding.sectionAppsRecycler.adapter = HorizontalAppAdapter(section.apps)

                    // Với section ngang, hiển thị mũi tên ở cuối
                    binding.sectionArrowButton.visibility = View.VISIBLE

                    // Icon 3 chấm cũng luôn hiển thị
                    binding.sectionMoreIcon.visibility = View.VISIBLE

                    // Thêm padding để item đầu tiên không bị dính sát lề
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
