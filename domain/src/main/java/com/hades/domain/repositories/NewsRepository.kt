package com.hades.domain.repositories

import com.hades.domain.entities.NewsSourcesDomain
import io.reactivex.Flowable

/**
 * Created by Hades on 2/19/2020.
 */
interface NewsRepository {

    fun getNews(): Flowable<NewsSourcesDomain>
    fun getLocalNews(): Flowable<NewsSourcesDomain>
    fun getRemoteNews(): Flowable<NewsSourcesDomain>

}