package com.hades.presentation.common

/**
 * Created by Hades on 2/20/2020.
 */
data class Data<RequestData>(
    var responseType: Status,
    var data: RequestData? = null,
    var error: Error? = null
)

data class Error(var message: String? = null)

enum class Status { SUCCESSFUL, ERROR, LOADING }