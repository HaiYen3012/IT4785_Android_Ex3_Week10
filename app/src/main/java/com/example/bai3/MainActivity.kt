package com.example.bai3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bai3.adapter.MainSectionAdapter
import com.example.bai3.model.AppItem
import com.example.bai3.model.PlayStoreSection
import com.example.bai3.model.SectionType

class MainActivity : AppCompatActivity() {

    private lateinit var contentRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contentRecyclerView = findViewById(R.id.mainRecyclerView)
        contentRecyclerView.layoutManager = LinearLayoutManager(this)

        val sectionList = createSampleData()
        contentRecyclerView.adapter = MainSectionAdapter(sectionList)
    }

    private fun createSampleData(): List<PlayStoreSection> {
        return listOf(
            // Section 1: Sponsored - Lấy 3 app đầu tiên cho danh sách dọc
            PlayStoreSection(
                id = 1,
                title = "Sponsored · Suggested for you",
                viewType = SectionType.VERTICAL_GROUP,
                apps = listOf(
                    AppItem("Mech Assemble: Zombie Swarm", "Action", 4.8f, "624 MB", "https://play-lh.googleusercontent.com/2anpQdZ2VZMk6isYItVsHLCGPvogdBKk4tKZ1LVysz6TeY1EpLgGjkYLGcRdzbdCOZhehBRDDJU-OMwjDErZ"),
                    AppItem("MU: Hồng Hoả Đao", "Role Playing", 4.8f, "339 MB", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWoKxW2Al7FtZcgxc7AzqdUBhF2ioNcO5gxg&s"),
                    AppItem("War Inc: Rising", "Strategy", 4.9f, "231 MB", "https://play-lh.googleusercontent.com/TlTT0BS4ndcYvLhxDEuXUci6QDbASrL52sC9VusupxrGqXcwe89uUV6hspns3EWaEQ")
                )
            ),

            // Section 2: Recommended for you
            PlayStoreSection(
                id = 2,
                title = "Recommended for you",
                viewType = SectionType.HORIZONTAL_SCROLL,
                apps = listOf(
                    AppItem("Suno - AI Music & Beat Maker", "Music & Audio", 4.5f, "50 MB", "https://play-lh.googleusercontent.com/5UR_1gDasYzAjJYSdx9onJ5FT68TVzxcV6O_FjTS2X_95_qHgexX__mCa_23lUIgWlU"),
                    AppItem("Claude by Anthropic", "Productivity", 4.7f, "45 MB", "https://play-lh.googleusercontent.com/4S1nfdKsH_1tJodkHrBHimqlCTE6qx6z22zpMyPaMc_Rlr1EdSFDI1I6UEVMnokG5zI"),
                    AppItem("DramaBox - Short Drama", "Entertainment", 4.3f, "78 MB", "https://play-lh.googleusercontent.com/dYAF42EhNGgGhC7nLHNSZkWs11W5Dv0mRWZBv6IgLDTh3l8eolsjeAVGg-HVHt9YWyA"),
                    AppItem("Pilot - Travel Assistant", "Travel", 4.6f, "52 MB", "https://play-lh.googleusercontent.com/I-LXgEXnrPtYK2vjhWJTboBDvD1z9UZVV_embK4sq7Z8GVUWZjnFaoLbTZqBY4S3Kr8Z"),
                    AppItem("PhotoRoom - BG Remover", "Photo & Video", 4.8f, "120 MB", "https://play-lh.googleusercontent.com/0Zb-LP5DFkezAVnX6ez5Op-qbchLdMffqIY9ct9qmmN1cMZlWCEBwK3BLIgKdi-X0Q"),
                    AppItem("Notion - Notes & Tasks", "Productivity", 4.6f, "95 MB", "https://play-lh.googleusercontent.com/vaxxIC1qaXOd1q1hmL7c66N-Mp4LXuQIuBZGM0dPIbwmyWcJAXbhIIZ8hNBWvar54c_j")
                )
            ),

            // Section 3: Popular games
            PlayStoreSection(
                id = 3,
                title = "Popular games",
                viewType = SectionType.HORIZONTAL_SCROLL,
                apps = listOf(
                    AppItem("PUBG Mobile", "Action", 4.2f, "750 MB", "https://play-lh.googleusercontent.com/9Q5je4kYh5EVvDLJSp20Vr6fFZB6qWAF0EtXj37o2h8yzD6vuvwa4fph83q7uIHkMQ7O=w240-h480-rw"),
                    AppItem("Mobile Legends", "MOBA", 4.1f, "450 MB", "https://play-lh.googleusercontent.com/t1qYs5Ern-dXiip7tUxlNbZQSTWm1wEeWe2-S5ViiIzgg3ccqcYGM0i-KhJ_zVIwd4bk3qqdhGBmy4ZN8nW8"),
                    AppItem("Genshin Impact", "RPG", 4.5f, "15 GB", "https://static.wikia.nocookie.net/logopedia/images/4/4f/Yuanshen_Icon.png/revision/latest/scale-to-width-down/250?cb=20241230080300"),
                    AppItem("Free Fire", "Battle Royale", 4.0f, "650 MB", "https://play-lh.googleusercontent.com/1wE91ae_1YIJtIjQ1YJz5RhAajxEpF1TfrXGg7tcrKl90MOnF7XdFj71pw_MSQbyhM5PYz-eRdeBFQBzSGrV"),
                    AppItem("Clash of Clans", "Strategy", 4.5f, "200 MB", "https://play-lh.googleusercontent.com/sFmWfYbYp_2ea7VRMTnwd3gjIBrPGXHj_d_ab1_k1q1p2OMk4riGMF1vqxdhONOtTYOt_BVpk7a4AYcKU68LNGQ")
                )
            ),

            // Section 4: New & updated apps
            PlayStoreSection(
                id = 4,
                title = "New & updated apps",
                viewType = SectionType.HORIZONTAL_SCROLL,
                apps = listOf(
                    AppItem("Telegram", "Communication", 4.3f, "85 MB", "https://play-lh.googleusercontent.com/ZU9cSsyIJZo6Oy7HTHiEPwZg0m2Crep-d5ZrfajqtsH-qgUXSqKpNA2FpPDTn-7qA5Q"),
                    AppItem("Twitter X", "Social", 3.9f, "95 MB", "https://play-lh.googleusercontent.com/XyI6Hyz9AFg7E_joVzX2zh6CpWm9B2DG2JuEz5meCFVm4-wTKTnHgqbmg62iFKe4Gzca=w240-h480-rw"),
                    AppItem("Instagram", "Social", 4.1f, "150 MB", "https://play-lh.googleusercontent.com/VRMWkE5p3CkWhJs6nv-9ZsLAs1QOg5ob1_3qg-rckwYW7yp1fMrYZqnEFpk0IoVP4LM"),
                    AppItem("WhatsApp", "Communication", 4.4f, "65 MB", "https://play-lh.googleusercontent.com/bYtqbOcTYOlgc6gqZ2rwb8lptHuwlNE75zYJu6Bn076-hTmvd96HH-6v7S0YUAAJXoJN"),
                    AppItem("TikTok", "Video", 4.2f, "180 MB", "https://play-lh.googleusercontent.com/Ui_-OW6UJI147ySDX9guWWDiCPSq1vtxoC-xG17BU2FpU0Fi6qkWwuLdpddmT9fqrA=w240-h480-rw")
                )
            )
        )
    }
}
