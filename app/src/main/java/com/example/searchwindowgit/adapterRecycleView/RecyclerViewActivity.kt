package com.example.searchwindowgit.adapterRecycleView

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.searchwindowgit.R
import com.example.searchwindowgit.viewModel.ViewModel
import kotlinx.android.synthetic.main.activity_recycler_view.*


class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)


        initRecyclerView()
        createData()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            Log.d("Starting initRecycler", "applied")
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

            val decoration = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(decoration)
        }
    }


    private fun createData() {
//

        val viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.getRecyclerListDataObserver().observe(this) {

            it?.let {

                recyclerViewAdapter.setListData(it.items)
                recyclerViewAdapter.notifyDataSetChanged()
            }



        }
        searchButton.setOnClickListener {
            viewModel.apiGetCalls()
        }

    }
}