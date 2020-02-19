package com.hades.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Hades on 2/19/2020.
 */
@Entity(tableName = "news_articles")
data class NewsData(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("category") var category: String? = null
)