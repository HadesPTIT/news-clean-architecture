package com.hades.presentation.common

import com.hades.domain.common.FlowableRxTransformer
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher

/**
 * Created by Hades on 2/20/2020.
 */
class AsyncFlowableTransformer<T> : FlowableRxTransformer<T>() {

    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

}