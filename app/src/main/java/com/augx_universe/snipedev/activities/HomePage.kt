package com.augx_universe.snipedev.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class HomePage : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    private lateinit var feedViewModel: FeedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_page)
        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        binding.bind = feedViewModel
        binding.lifecycleOwner = this


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
}