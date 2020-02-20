package com.hades.presentation.di

import com.hades.data.api.NewsApi
import com.hades.data.db.NewsDatabase
import com.hades.data.entities.NewsDataToDomainMapper
import com.hades.data.entities.NewsDomainToDataMapper
import com.hades.data.repository.NewsCacheImpl
import com.hades.data.repository.NewsRemoteImpl
import com.hades.data.repository.NewsRepositoryImpl
import com.hades.domain.repositories.NewsRepository
import com.hades.domain.usecases.GetNewsUseCase
import com.hades.presentation.common.AsyncFlowableTransformer
import com.hades.presentation.entities.NewsDomainToPresentMapper
import com.hades.presentation.news.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by Hades on 2/20/2020.
 */
val networkModule = module {
    single { NewsApi.create() }
}

val localModule = module {
    single { NewsDatabase.getInstance(get()) }
    single { NewsDatabase.getInstance(get()).getNewsDao() }
}

val repositoryModule = module {
    single(named(REMOTE_API)) {
        NewsRemoteImpl(api = get())
    }
    single(named(LOCAL_API)) {
        NewsCacheImpl(
            database = get(),
            domainToDataMapper = NewsDomainToDataMapper(),
            dataToDomainMapper = NewsDataToDomainMapper()
        )
    }
    single {
        NewsRepositoryImpl(
            remote = get(named(REMOTE_API)),
            cache = get(named(LOCAL_API))
        ) as NewsRepository
    }
}

val useCaseModule = module {
    factory(named(GET_NEWS_USECASE)) {
        GetNewsUseCase(transformer = AsyncFlowableTransformer(), repositories = get())
    }
}

val viewModelModule = module {
    viewModel {
        NewsViewModel(
            getNewsUseCase = get(named(GET_NEWS_USECASE)),
            mapper = NewsDomainToPresentMapper()
        )
    }
}

private const val GET_NEWS_USECASE = "getNewsUseCase"
private const val REMOTE_API = "remote"
private const val LOCAL_API = "local"
