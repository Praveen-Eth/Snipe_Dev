package com.augx_universe.snipedev

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amrdeveloper.codeview.CodeView
import de.hdodenhof.circleimageview.CircleImageView

class RvAdapter(private val listOfFeedItems: List<FeedItem>): RecyclerView.Adapter<RvAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_card_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfFeedItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feedItem = listOfFeedItems[position]
        holder.profileImage = feedItem.profileImage
        holder.userName.text = feedItem.userNameText
        holder.followerCount.text = feedItem.followerCount.toString()
        holder.codeView = feedItem.code

    }
    class ViewHolder(ViewItems: View): RecyclerView.ViewHolder(ViewItems){
        var profileImage:CircleImageView = ViewItems.findViewById(R.id.profileImage)
        var userName: TextView = ViewItems.findViewById(R.id.userName)
        var followerCount : TextView= ViewItems.findViewById(R.id.followersTextView)
        var codeView: CodeView = ViewItems.findViewById(R.id.codeView)

    }
}