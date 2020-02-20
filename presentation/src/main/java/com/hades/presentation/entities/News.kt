package com.hades.presentation.entities

/**
 * Created by Hades on 2/20/2020.
 */
data class News(
    var id: Int,
    var name: String? = null,
    var description: String? = null,
    var url: String? = null,
    var category: String? = null,
    var title : String? = null,
    var urlToImage : String? = null
)