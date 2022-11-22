package com.example.searchwindowgit.adapterRecycleView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.searchwindowgit.R
import com.example.searchwindowgit.viewModel.ViewModel
import kotlinx.android.synthetic.main.activity_recycler_view.*


class RecyclerViewActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)


        initRecyclerView()
        createData()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

            val decoration = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(decoration)
        }
    }


    private fun createData() {


        val viewModel = ViewModelProviders.of(this)[ViewModel::class.java]
        viewModel.getRecyclerListDataObserver().observe(this) {


            recyclerViewAdapter.setListData(it.items)
            recyclerViewAdapter.notifyDataSetChanged()


        }
        searchButton.setOnClickListener {
            viewModel.apiGetCalls(searchBoxId.text.toString())
        }

    }
}