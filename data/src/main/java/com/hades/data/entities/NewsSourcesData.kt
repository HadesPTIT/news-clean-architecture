package com.hades.data.entities

import com.google.gson.annotations.SerializedName
import com.hades.domain.entities.NewsDomain
import com.hades.domain.entities.NewsSourcesDomain

/**
 * Created by Hades on 2/19/2020.
 */
data class NewsSourcesData(
    @SerializedName("status") var status: String? = null,
    @SerializedName("articles") var articles: List<NewsData> = emptyList()
)

/**
 *  Mapper from Data Entity to Domain
 */
class NewsDataToDomainMapper {

    fun mapToDomain(data: NewsSourcesData?): NewsSourcesDomain? = NewsSourcesDomain(
        status = data?.status,
        articles = mapListArticlesToDomain(data?.articles)
    )

    fun mapToDomain(articles: List<NewsData>?): NewsSourcesDomain? = NewsSourcesDomain(
        articles = mapListArticlesToDomain(articles)
    )

    private fun mapListArticlesToDomain(articles: List<NewsData>?): List<NewsDomain> {
        return articles?.map { mapArticleToDomain(it) } ?: emptyList()
    }

    private fun mapArticleToDomain(article: NewsData) = NewsDomain(
        id = article.id,
        name = article.name,
        description = article.description,
        category = article.category,
        url = article.url,
        title = article.title,
        urlToImage = article.urlToImage
    )
}

/**
 *  Mapper from Domain Entity to Data
 */
class NewsDomainToDataMapper {

    fun mapToData(data: NewsSourcesDomain?): NewsSourcesData? = NewsSourcesData(
        status = data?.status,
        articles = mapListArticlesToData(data?.articles)
    )

    fun mapListArticlesToData(articles: List<NewsDomain>?): List<NewsData> {
        return articles?.map { mapArticleToData(it) } ?: emptyList()
    }

    fun mapArticleToData(article: NewsDomain) = NewsData(
        id = article.id,
        name = article.name,
        description = article.description,
        category = article.category,
        url = article.url,
        title = article.title,
        urlToImage = article.urlToImage
    )

}
