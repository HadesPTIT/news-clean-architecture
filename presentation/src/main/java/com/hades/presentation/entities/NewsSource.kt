package com.hades.presentation.entities

import com.hades.domain.common.Mapper
import com.hades.domain.entities.NewsDomain
import com.hades.domain.entities.NewsSourcesDomain

/**
 * Created by Hades on 2/20/2020.
 */
data class NewsSource(
    var status: String? = null,
    var articles: List<News> = emptyList()
)

/**
 *  Mapper from Domain to Presenter
 */
class NewsDomainToPresentMapper : Mapper<NewsSourcesDomain, NewsSource>() {

    override fun mapFrom(from: NewsSourcesDomain): NewsSource = NewsSource(
        status = from.status,
        articles = mapListArticlesToPresent(from.articles)
    )

    private fun mapListArticlesToPresent(articles: List<NewsDomain>?): List<News> {
        return articles?.map { mapArticleToPresenter(it) } ?: emptyList()
    }

    private fun mapArticleToPresenter(response: NewsDomain): News = News(
        id = response.id,
        name = response.name,
        description = response.description,
        url = response.url,
        category = response.category,
        title = response.title,
        urlToImage = response.urlToImage
    )

}

