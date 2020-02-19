package com.hades.data.repository

import com.hades.data.api.NewsApi
import com.hades.data.entities.NewsDataToDomainMapper
import com.hades.domain.entities.NewsSourcesDomain
import io.reactivex.Flowable

/**
 * Created by Hades on 2/19/2020.
 */
class NewsRemoteImpl(private val api: NewsApi) : NewsDataStore {

    private val newsMapper = NewsDataToDomainMapper()

    override fun getNews(): Flowable<NewsSourcesDomain> {
        return api.getNews().map {
            newsMapper.mapToDomain(it)
        }
    }
}