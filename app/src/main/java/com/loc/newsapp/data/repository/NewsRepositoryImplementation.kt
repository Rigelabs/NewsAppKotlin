package com.loc.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.loc.newsapp.data.remote.NewsPagingSource
import com.loc.newsapp.data.remote.api.NewsApi
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.Newsrepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImplementation( private val newsApi:NewsApi):Newsrepository{
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
      return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}