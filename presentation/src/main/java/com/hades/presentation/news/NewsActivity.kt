package com.hades.presentation.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hades.presentation.R
import com.hades.presentation.common.Status
import kotlinx.android.synthetic.main.activity_news.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Hades on 2/20/2020.
 */
class NewsActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModel()
    private val newsAdapter by lazy { NewsListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        recycler_news.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler_news.adapter = newsAdapter
        viewModel.mNews.observe(this, Observer {
            when (it?.responseType) {
                Status.ERROR -> {

                }
                Status.LOADING -> {

                }
                Status.SUCCESSFUL -> {

                }
            }
            it?.data?.let { response ->
                newsAdapter.updateList(response.articles)
            }
        })

    }

}