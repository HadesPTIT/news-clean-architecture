package com.hades.domain.usecases

import com.hades.domain.common.BaseFlowableUseCase
import com.hades.domain.common.FlowableRxTransformer
import com.hades.domain.entities.NewsSourcesDomain
import com.hades.domain.repositories.NewsRepository
import io.reactivex.Flowable

/**
 * Created by Hades on 2/19/2020.
 */
class GetNewsUseCase(
    private val transformer: FlowableRxTransformer<NewsSourcesDomain>,
    private val repositories: NewsRepository
) : BaseFlowableUseCase<NewsSourcesDomain>(transformer) {

    override fun createFlowable(data: Map<String, Any>?): Flowable<NewsSourcesDomain> {
        return repositories.getNews()
    }

    /**
     * Using in viewModel when fetch news
     */
    fun getNews(): Flowable<NewsSourcesDomain> {
        val data = HashMap<String, String>()
        return single(data)
    }
}