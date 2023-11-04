package com.loc.newsapp.domain.repository

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface Newsrepository {
    fun getNews(sources:List<String>):Flow<PagingData<Article>>
}