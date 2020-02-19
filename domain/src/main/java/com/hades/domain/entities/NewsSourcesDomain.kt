package com.hades.domain.entities

/**
 * Created by Hades on 2/19/2020.
 */
data class NewsSourcesDomain(
    var status: String? = null,
    var articles: List<NewsDomain> = emptyList()
)