package com.hades.data.api

import com.hades.data.BuildConfig
import com.hades.data.entities.NewsSourcesData
import io.reactivex.Flowable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Hades on 2/19/2020.
 */
interface NewsApi {

    @GET("top-headlines?country=us")
    fun getNews(): Flowable<NewsSourcesData>

    companion object {

        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "apiKey"

        fun create() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getHttpClient())
            .build()
            .create(NewsApi::class.java)

        private fun getHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addNetworkInterceptor(getNetworkInterceptor())
                .addInterceptor(getHttpLogingInterceptor())
                .build()
        }

        private fun getHttpLogingInterceptor(): HttpLoggingInterceptor {
            return if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            } else {
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
            }
        }

        private fun getNetworkInterceptor(): Interceptor = Interceptor { chain ->
            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter(API_KEY, BuildConfig.API_KEY)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }


    }
}