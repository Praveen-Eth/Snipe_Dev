package com.augx_universe.snipedev.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.amrdeveloper.codeview.Code
import com.amrdeveloper.codeview.CodeView
import com.augx_universe.snipedev.entities.FeedItem
import com.augx_universe.snipedev.R
import de.hdodenhof.circleimageview.CircleImageView
import java.util.regex.Pattern

class RvAdapter(private val listOfFeedItems: List<FeedItem>, var appContext: Context): RecyclerView.Adapter<RvAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_card_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfFeedItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feedItem = listOfFeedItems[position]
        holder.profileImage.setImageResource(feedItem.profileImage)
        holder.userName.text = feedItem.userNameText
        holder.followerCount.text = "Follower: "+feedItem.followerCount.toString()

        holder.codeView.text =  feedItem.code

    }
    class ViewHolder(ViewItems: View): RecyclerView.ViewHolder(ViewItems){
        var profileImage:CircleImageView = ViewItems.findViewById(R.id.profileImage)
        var userName: TextView = ViewItems.findViewById(R.id.userNameTextView)
        var followerCount : TextView= ViewItems.findViewById(R.id.followersTextView)
        var codeView: TextView = ViewItems.findViewById(R.id.codeView)

    }
}