package com.example.searchwindowgit.retrofitFactory

import android.util.Log
import com.example.searchwindowgit.utilities.jsonDefaultInstance
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit





object RetroInstance {


    private val contentType = "application/json".toMediaType() // for working json
    private const val baseURL = "https://api.github.com"
    fun getRetroInstance(): Retrofit {
        Log.d("Starting retro", "before converter")
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(jsonDefaultInstance.asConverterFactory(contentType))//problems with json
            .client(mOkHttpClient)
            .build()

    }
}
