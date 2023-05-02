package com.augx_universe.snipedev.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.augx_universe.snipedev.adapters.RvAdapter
import com.augx_universe.snipedev.entities.FeedItem
import com.augx_universe.snipedev.R
import com.augx_universe.snipedev.view_models.FeedViewModel
import com.augx_universe.snipedev.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    private lateinit var feedViewModel: FeedViewModel
    lateinit var recyclerView:RecyclerView
    lateinit var feedList: List<FeedItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_page)
        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        binding.bind = feedViewModel
        binding.lifecycleOwner = this


        feedList = emptyArray<FeedItem>().toList()

        var exampleCode = getString(R.string.example_code)
         feedList = feedList+(FeedItem(R.drawable.close_monkey,"monkey king",1000,exampleCode))
        var adapter: RvAdapter = RvAdapter(feedList,applicationContext)
        binding.feedRecyclerView.adapter = adapter
        binding.feedRecyclerView.layoutManager = LinearLayoutManager(this)














    }
}