package com.augx_universe.snipedev.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.augx_universe.snipedev.adapters.RvAdapter
import com.augx_universe.snipedev.entities.FeedItem
import com.augx_universe.snipedev.R
import com.augx_universe.snipedev.view_models.FeedViewModel
import com.augx_universe.snipedev.databinding.ActivityHomePageBinding
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class HomePage : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    private lateinit var feedViewModel: FeedViewModel
    var doubleClickToExitFlag = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_page)
        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        binding.bind = feedViewModel
        binding.lifecycleOwner = this
            loadFragment(R.id.fragment_container_homePage,HomePageFeed())




            binding.navigationBarBottom.setOnItemSelectedListener {item ->
            when(item.itemId){
                R.id.home_feed ->
                {    loadFragment(R.id.fragment_container_homePage,HomePageFeed())
                        true
                }
                R.id.search_bar -> {
                    loadFragment(R.id.fragment_container_homePage,SearchBar())
                        true
                }
                R.id.add_post -> {
                    loadFragment(R.id.fragment_container_homePage,SearchBar())
                    true
                }
                R.id.saved_post -> {
                loadFragment(R.id.fragment_container_homePage,SearchBar())
                true
            }
                R.id.profile -> {
                loadFragment(R.id.fragment_container_homePage,SearchBar())
                true
            }

                else -> {
                        Toast.makeText(this,"invalid item",Toast.LENGTH_SHORT).show()
                    false
                }
            }

        }






    }
    fun loadFragment(container: Int,fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(container,fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if(doubleClickToExitFlag){
            super.getOnBackPressedDispatcher().onBackPressed()
            return
        }
        this.doubleClickToExitFlag = true
        Toast.makeText(this,"Press once again to exit!",Toast.LENGTH_SHORT).show()
        val executor = Executors.newSingleThreadScheduledExecutor()
        executor.schedule({
            this.doubleClickToExitFlag = false
        },2000,TimeUnit.MILLISECONDS)


    }
}