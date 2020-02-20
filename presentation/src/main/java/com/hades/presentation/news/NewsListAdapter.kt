package com.hades.presentation.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hades.presentation.R
import com.hades.presentation.entities.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * Created by Hades on 2/20/2020.
 */
class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    var articles = mutableListOf<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(newsItem: News) {
            with(itemView) {
                tv_title.text = newsItem.title
                tv_heading.text = newsItem.description
                if (!newsItem.urlToImage.isNullOrEmpty()) {
                    Picasso.with(itemView.context).load(newsItem.urlToImage).into(image)
                }
            }
        }
    }

    fun updateList(list: List<News>) {
        if (list.isNotEmpty()) {
            articles.clear()
            articles.addAll(list)
            notifyDataSetChanged()
        }
    }
}