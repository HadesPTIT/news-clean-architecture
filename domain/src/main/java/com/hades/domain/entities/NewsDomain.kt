package com.hades.domain.entities

/**
 * Created by Hades on 2/19/2020.
 */
data class NewsDomain(
    var id: Int,
    var name: String? = null,
    var description: String? = null,
    var url: String? = null,
    var category: String? = null
)