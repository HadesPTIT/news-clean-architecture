package com.hades.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hades.data.entities.NewsData
import io.reactivex.Flowable

/**
 * Created by Hades on 2/19/2020.
 */
@Dao
interface NewsDao {

    @Query("SELECT * FROM news_articles")
    fun getAllArticles(): Flowable<List<NewsData>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllArticles(articles: List<NewsData>)

    @Query("DELETE FROM news_articles")
    fun clear()

}