package com.loc.newsapp.data.remote.api

import com.loc.newsapp.data.remote.datatransfterobject.NewsResponse
import com.loc.newsapp.utils.Constant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page:Int,
        @Query("sources") sources:String,
        @Query("apikey") apiKey:String = API_KEY
    ):NewsResponse
}