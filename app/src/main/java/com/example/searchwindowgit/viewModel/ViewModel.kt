package com.example.searchwindowgit.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchwindowgit.dataClass.SearchList
import com.example.searchwindowgit.retrofitFactory.RetroInstance
import com.example.searchwindowgit.retrofitFactory.RetroService
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@AndroidEntryPoint

class ViewModel : ViewModel() {

    var searchListData: MutableLiveData<SearchList> = MutableLiveData()


    fun getRecyclerListDataObserver(): MutableLiveData<SearchList> {
        return searchListData
    }

    fun apiGetCalls() {

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)


        val call = retroInstance.getApiFromHub()

        call.enqueue(object : Callback<SearchList> {
            override fun onResponse(call: Call<SearchList>, response: Response<SearchList>) {
                if (response.isSuccessful) {
                    Log.d("Tag : work", response.body().toString())

                    searchListData.postValue(response.body())
                } else {
                    searchListData.postValue(null)
                }
            }

            override fun onFailure(call: Call<SearchList>, t: Throwable) {
                Log.e("TAG  : fail", t.message.toString())


                searchListData.postValue(null)
            }
        })
    }
}