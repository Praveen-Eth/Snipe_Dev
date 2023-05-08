package com.augx_universe.snipedev.adapters

import android.content.Context
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.amrdeveloper.codeview.CodeView
import com.augx_universe.snipedev.R
import com.augx_universe.snipedev.entities.FeedItem
import com.augx_universe.snipedev.entities.LanguageKeyWords
import de.hdodenhof.circleimageview.CircleImageView
import java.util.regex.Pattern


class RvAdapter(private val listOfFeedItems: List<FeedItem>,val context: Context): RecyclerView.Adapter<RvAdapter.ViewHolder>() {


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

        holder.codeView.apply {


            addSyntaxPattern(
                Pattern.compile("(\".*?\"|'.*?'|/\\*.*?\\*/|//.*?$)"),
                ContextCompat.getColor(context, R.color.green)
            )

            addSyntaxPattern(
                Pattern.compile("\\b(public|private|protected|static|final|abstract|native|synchronized|transient|volatile)\\b"),
                ContextCompat.getColor(context, R.color.purple)
            )

            addSyntaxPattern(
                Pattern.compile("\\b(class|interface|enum)\\b"),
                ContextCompat.getColor(context, R.color.primitive_type)
            )

            addSyntaxPattern(
                Pattern.compile("\\b(package|import|override)\\b"),
                ContextCompat.getColor(context, R.color.dark_green)
            )

            addSyntaxPattern(
                Pattern.compile("\\b(void|int|byte|short|long|float|double|boolean|char)\\b"),
                ContextCompat.getColor(context, R.color.orange)
            )

            addSyntaxPattern(
                Pattern.compile("\\b(if|else|for|while|do|switch|case|break|continue|default|return|try|catch|finally|throw|throws|new|instanceof)\\b"),
                ContextCompat.getColor(context, R.color.red)
            )

            text = Editable.Factory.getInstance().newEditable(feedItem.code)
            isFocusable = false
            isFocusableInTouchMode = false

        }


    }
    class ViewHolder(ViewItems: View): RecyclerView.ViewHolder(ViewItems){
        var profileImage:CircleImageView = ViewItems.findViewById(R.id.profileImage)
        var userName: TextView = ViewItems.findViewById(R.id.userNameTextView)
        var followerCount : TextView= ViewItems.findViewById(R.id.followersTextView)
        var codeView: CodeView = ViewItems.findViewById(R.id.codeView)


    }
}