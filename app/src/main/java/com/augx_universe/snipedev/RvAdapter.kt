package com.augx_universe.snipedev

import android.content.Context
import android.provider.Settings.Global.getString
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EdgeEffect
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.amrdeveloper.codeview.CodeView
import de.hdodenhof.circleimageview.CircleImageView
import java.util.regex.Pattern

class RvAdapter(private val listOfFeedItems: List<FeedItem>,var appContext: Context): RecyclerView.Adapter<RvAdapter.ViewHolder>() {


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

        val codeView = feedItem.code
        codeView.apply {
            var javaKeywords = arrayOf("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while")
            var arrayAdapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,javaKeywords)

            codeView.setAdapter(arrayAdapter)
            codeView.addSyntaxPattern(Pattern.compile("\\b(" + javaKeywords.joinToString("|") + ")\\b"), ContextCompat.getColor(context,R.color.javaCodeTheme))
        }
        holder.codeView = codeView

    }
    class ViewHolder(ViewItems: View): RecyclerView.ViewHolder(ViewItems){
        var profileImage:CircleImageView = ViewItems.findViewById(R.id.profileImage)
        var userName: TextView = ViewItems.findViewById(R.id.userNameTextView)
        var followerCount : TextView= ViewItems.findViewById(R.id.followersTextView)
        var codeView: CodeView = ViewItems.findViewById(R.id.codeView)

    }
}