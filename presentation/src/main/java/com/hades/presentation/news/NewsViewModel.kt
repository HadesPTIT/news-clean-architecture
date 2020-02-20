package com.hades.presentation.news

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hades.domain.common.Mapper
import com.hades.domain.entities.NewsSourcesDomain
import com.hades.domain.usecases.GetNewsUseCase
import com.hades.presentation.common.BaseViewModel
import com.hades.presentation.common.Data
import com.hades.presentation.common.Error
import com.hades.presentation.common.Status
import com.hades.presentation.entities.NewsSource

/**
 * Created by Hades on 2/20/2020.
 */

class NewsViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val mapper: Mapper<NewsSourcesDomain, NewsSource>
) : BaseViewModel() {

    var mNews = MutableLiveData<Data<NewsSource>>()

    init {
        fetchNews()
    }

    fun fetchNews() {
        val disposable = getNewsUseCase.getNews()
            .flatMap {
                mapper.Flowable(it)
            }.subscribe({ response ->
                Log.d(TAG, "On Next Called")
                mNews.value = Data(responseType = Status.SUCCESSFUL, data = response)
            }, { error ->
                Log.d(TAG, "On Error Called")
                mNews.value = Data(responseType = Status.ERROR, error = Error(error.message))
            }, {
                Log.d(TAG, "On Complete Called")
            })
        addDisposable(disposable)
    }

    companion object {
        private val TAG = "NewsViewModel"
    }
}