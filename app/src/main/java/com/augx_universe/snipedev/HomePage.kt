package com.augx_universe.snipedev

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.augx_universe.snipedev.databinding.ActivityHomePageBinding
import com.google.firebase.auth.FederatedAuthProvider

class HomePage : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    private lateinit var feedViewModel: FeedViewModel
    lateinit var recyclerView:RecyclerView
    lateinit var feedList: List<FeedItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home_page)
        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        binding.bind = feedViewModel
        binding.lifecycleOwner = this

        feedList = emptyList()
        var adapter: RvAdapter = RvAdapter(feedList)
        binding.feedRecyclerView.adapter = adapter








    }
}