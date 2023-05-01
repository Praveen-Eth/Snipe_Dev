package com.augx_universe.snipedev

import android.animation.ObjectAnimator
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Layout
import android.view.View
import android.view.WindowManager
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrdeveloper.codeview.Code
import com.amrdeveloper.codeview.CodeView
import com.augx_universe.snipedev.databinding.ActivityHomePageBinding
import com.google.firebase.auth.FederatedAuthProvider
import java.util.regex.Pattern

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


        feedList = emptyArray<FeedItem>().toList()

        var exampleCode = getString(R.string.example_code)
         feedList = feedList+(FeedItem(R.drawable.close_monkey,"monkey king",1000,exampleCode))
        var adapter: RvAdapter = RvAdapter(feedList,applicationContext)
        binding.feedRecyclerView.adapter = adapter
        binding.feedRecyclerView.layoutManager = LinearLayoutManager(this)














    }
}