package com.example.searchwindowgit.retrofitFactory

import com.example.searchwindowgit.dataClass.SearchList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    fun getApiFromHub(@Query("q") query: String): Call<SearchList>

}