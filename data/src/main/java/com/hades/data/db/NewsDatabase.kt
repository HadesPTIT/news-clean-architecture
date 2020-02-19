package com.hades.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hades.data.entities.NewsData

/**
 * Created by Hades on 2/19/2020.
 */
@Database(entities = [NewsData::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao

}