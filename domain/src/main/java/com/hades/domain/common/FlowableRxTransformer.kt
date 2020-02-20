package com.hades.domain.common

import io.reactivex.FlowableTransformer

/**
 * Created by Hades on 2/19/2020.
 */
abstract class FlowableRxTransformer<T> : FlowableTransformer<T, T>