package com.hades.data.api

import com.hades.data.entities.NewsSourcesData
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by Hades on 2/19/2020.
 */
interface NewsApi {

    @GET("top-headlines?country=us")
    fun getNews(): Flowable<NewsSourcesData>

}