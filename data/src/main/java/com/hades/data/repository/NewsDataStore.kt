package com.hades.data.repository

import com.hades.domain.entities.NewsSourcesDomain
import io.reactivex.Flowable

/**
 * Created by Hades on 2/19/2020.
 */
interface NewsDataStore {
    fun getNews(): Flowable<NewsSourcesDomain>
}