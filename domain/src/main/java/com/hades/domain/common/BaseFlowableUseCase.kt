package com.hades.domain.common

import io.reactivex.Flowable

/**
 * Created by Hades on 2/19/2020.
 */
abstract class BaseFlowableUseCase<T>(private val transformer: FlowableRxTransformer<T>) {

    abstract fun createFlowable(data : Map<String, Any>? = null) : Flowable<T>

    fun single(withData : Map<String, Any>? = null) : Flowable<T> {
        return createFlowable(withData).compose(transformer)
    }

}