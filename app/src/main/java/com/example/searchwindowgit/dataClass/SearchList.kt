package com.example.searchwindowgit.dataClass

import kotlinx.serialization.*

@Serializable
data class SearchList    (
    @SerialName("total_count")
    val count: Int,
    @SerialName("incomplete_results")
    val res: Boolean,
    val items: ArrayList<RecyclerData>
    )

