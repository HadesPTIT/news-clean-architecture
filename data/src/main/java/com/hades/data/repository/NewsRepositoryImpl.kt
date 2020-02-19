package com.hades.data.repository

import com.hades.domain.entities.NewsSourcesDomain
import com.hades.domain.repositories.NewsRepository
import io.reactivex.Flowable

/**
 * Created by Hades on 2/19/2020.
 */
class NewsRepositoryImpl(
    private val remote: NewsRemoteImpl,
    private val cache: NewsCacheImpl
) : NewsRepository {

    override fun getNews(): Flowable<NewsSourcesDomain> {
        val updateNewsFlowable = remote.getNews()
        return cache.getNews()
            .mergeWith(updateNewsFlowable.doOnNext { remoteNews ->
                cache.saveArticles(remoteNews)
            })
    }

    override fun getLocalNews(): Flowable<NewsSourcesDomain> {
        return cache.getNews()
    }

    override fun getRemoteNews(): Flowable<NewsSourcesDomain> {
        return remote.getNews()
    }
}