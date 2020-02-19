package com.hades.data.repository

import com.hades.data.db.NewsDao
import com.hades.data.db.NewsDatabase
import com.hades.data.entities.NewsDataToDomainMapper
import com.hades.data.entities.NewsDomainToDataMapper
import com.hades.domain.entities.NewsSourcesDomain
import io.reactivex.Flowable

/**
 * Created by Hades on 2/19/2020.
 */
class NewsCacheImpl(
    private val database: NewsDatabase,
    private val domainToDataMapper: NewsDomainToDataMapper,
    private val dataToDomainMapper: NewsDataToDomainMapper
) : NewsDataStore {

    private val dao: NewsDao = database.getNewsDao()

    override fun getNews(): Flowable<NewsSourcesDomain> {
        return dao.getAllArticles().map {
            dataToDomainMapper.mapToDomain(it)
        }
    }

    fun saveArticles(list: NewsSourcesDomain) {
        dao.clear()
        dao.saveAllArticles(list.articles.map { domainToDataMapper.mapArticleToData(it) })
    }

}