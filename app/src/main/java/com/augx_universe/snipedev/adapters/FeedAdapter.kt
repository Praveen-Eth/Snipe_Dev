package com.augx_universe.snipedev.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

import androidx.recyclerview.widget.RecyclerView
import com.augx_universe.snipedev.R
import com.augx_universe.snipedev.entities.CodeSnippetItem
import com.augx_universe.snipedev.entities.FeedDataClass
import com.augx_universe.snipedev.entities.PollItems

class FeedAdapter (private val item: List<FeedDataClass>,private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val Poll_View_Type = 0
        const val Code_View_Type = 1
        var pollColorList: List<Int> = listOf(Color.YELLOW, Color.GRAY, Color.GREEN, Color.BLUE)
    }

    inner class PollViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var profileImage: ImageView = view.findViewById(R.id.profileImage)
        var userName: TextView = view.findViewById(R.id.userNameTextView)
        var follower_Count: TextView = view.findViewById(R.id.followersTextView)

        var pollItemLayout = view.findViewById<LinearLayout>(R.id.HolderForPollView)
        fun bind(pollItem: PollItems) {
            for (i in 1..pollItem.options.size) {
                var view = LayoutInflater.from(context).inflate(R.layout.default_poll_bar, null)
                var pollBackGround: CardView = view.findViewById(R.id.PollBackGround)
                var pollTitle: TextView = view.findViewById(R.id.PollTitle)
                pollTitle.text = "${pollItem.options[i-1]} ${(pollItem.votePercentageList[i-1]*100f).toInt()} %"
                var derivedWidth = (pollItem.votePercentageList[i-1]*1000f).toInt()
                Log.d("debugs","$derivedWidth")
                pollBackGround.setCardBackgroundColor(pollColorList[i])
                pollBackGround.layoutParams.width = derivedWidth
                pollBackGround.requestLayout()
                pollItemLayout.addView(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Poll_View_Type -> {
                val pollView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.poll_item_layout, parent, false)
                return PollViewHolder(pollView)
            }
            else -> {
                throw IllegalArgumentException("error at creating PollView")
            }
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = item[position]
        return when (holder.itemViewType) {
            Poll_View_Type -> {
                val pollVH = holder as PollViewHolder
                pollVH.bind(item as PollItems)
            }
            else -> {
                throw IllegalArgumentException("error at binding ")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = item[position]
        return when (item) {
            is PollItems -> Poll_View_Type
            is CodeSnippetItem -> Code_View_Type
            else -> throw java.lang.IllegalArgumentException("invalid Item View")
        }


    }
}
