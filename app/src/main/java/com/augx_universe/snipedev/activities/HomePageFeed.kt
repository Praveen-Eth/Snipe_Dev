package com.augx_universe.snipedev.activities

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.augx_universe.snipedev.R
import com.augx_universe.snipedev.adapters.RvAdapter
import com.augx_universe.snipedev.databinding.FragmentHomePageFeedBinding
import com.augx_universe.snipedev.entities.FeedItem
import com.augx_universe.snipedev.view_models.FeedViewModel


class HomePageFeed : Fragment() {
    private lateinit var feedViewModel: FeedViewModel
    private lateinit var binding: FragmentHomePageFeedBinding
    private lateinit var activityContext: Context
    var feedList = emptyList<FeedItem>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activityContext = requireContext()
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page_feed,container,false)
        feedViewModel = ViewModelProvider(requireActivity()).get(FeedViewModel::class.java)
        binding.bind = feedViewModel

        feedList.plus(FeedItem(R.drawable.open_monkey,"Monkey king",1200, getString(R.string.example_code)))
        feedList.plus(FeedItem(R.drawable.close_monkey,"Monkey queen",900, getString(R.string.example_code_2)))

        var adapter = RvAdapter(feedList,requireContext())
        binding.feedRecyclerView.adapter =adapter
        binding.feedRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       super.onViewCreated(view, savedInstanceState)





    }


}