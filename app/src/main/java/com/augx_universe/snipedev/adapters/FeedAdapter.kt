package com.augx_universe.snipedev.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.augx_universe.snipedev.R
import com.augx_universe.snipedev.entities.FeedDataClass
import java.util.zip.Inflater

class FeedAdapter(private val items: List<FeedDataClass>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{
        val POLL_ITEM_VIEW_TYPE = 0
        val CODE_SNIPPET_ITEM_VIEW_TYPE = 1
        val CODE_COMPETETITON_ITEM_VIEW_TYPE = 2

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            POLL_ITEM_VIEW_TYPE -> LayoutInflater.from(parent).inflate(R.layout.)

        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}
