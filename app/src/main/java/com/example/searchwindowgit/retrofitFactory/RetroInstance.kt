package com.example.searchwindowgit.retrofitFactory

import com.example.searchwindowgit.utilities.jsonDefaultInstance
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


class RetroInstance {

    companion object {
        private val contentType = "application/json".toMediaType()
        private const val baseURL = "https://api.github.com/search/"
        fun getRetroInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(jsonDefaultInstance.asConverterFactory(contentType))
                .build()
        }
    }
}