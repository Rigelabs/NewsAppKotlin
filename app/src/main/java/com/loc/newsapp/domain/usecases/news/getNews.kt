package com.loc.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.Newsrepository
import kotlinx.coroutines.flow.Flow

class getNews (private val newsRepository : Newsrepository){
    operator fun invoke(sources:List<String>):Flow<PagingData<Article>>{
        return newsRepository.getNews(sources=sources)
    }
}