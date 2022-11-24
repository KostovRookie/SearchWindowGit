package com.example.searchwindowgit.adapterRecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.searchwindowgit.R
import com.example.searchwindowgit.dataClass.RecyclerData
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var items = ArrayList<RecyclerData>()

    fun setListData(data: ArrayList<RecyclerData>) {
        this.items = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)

        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val title: TextView = view.viewTitle
       private val image: ImageView = view.imageThumb

        fun bind(data: RecyclerData) {
            title.text = data.login // user name binding

            //image avatar settings from glide
            val url = data.avatar_url
            Glide.with(image)
                .load(url)
                .placeholder(R.drawable.default_thumb)
                .error(R.drawable.default_thumb)
                .fallback(R.drawable.default_thumb)
                .into(image)
        }

    }

}