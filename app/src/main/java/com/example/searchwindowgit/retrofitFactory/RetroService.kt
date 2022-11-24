package com.example.searchwindowgit.retrofitFactory

import com.example.searchwindowgit.dataClass.SearchList
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {

    @GET("search/users?q=Q")
    fun getApiFromHub(): Call<SearchList>




//    @GET("repositories") // testing for json to copy search box
//    fun getApiFromHub(@Query("q") query: String): Call<SearchList>
}