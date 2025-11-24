package com.example.bai3.model

data class AppItem(
    val name: String,
    val category: String = "",
    val rating: Float,
    val size: String = "",
    val imageUrl: String
)

data class PlayStoreSection(
    val id: Int,
    val title: String,
    val viewType: SectionType,
    val apps: List<AppItem>
)

enum class SectionType {
    VERTICAL_GROUP,      // Dành cho section "Suggested for you"
    HORIZONTAL_SCROLL    // Dành cho section "Recommended for you"
}
