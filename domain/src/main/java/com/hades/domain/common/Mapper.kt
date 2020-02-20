package com.hades.domain.common

/**
 * Created by Hades on 2/19/2020.
 */
abstract class Mapper<in T, E> {

    abstract fun mapFrom(from: T): E

    fun Flowable(from: T) = io.reactivex.Flowable.fromCallable { mapFrom(from) }

    fun Flowable(from: List<T>) = io.reactivex.Flowable.fromCallable { from.map { mapFrom(it) } }
}