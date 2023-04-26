package com.augx_universe.snipedev


import com.amrdeveloper.codeview.CodeView
import de.hdodenhof.circleimageview.CircleImageView


data class FeedItem(val profileImage: CircleImageView,val userNameText: String,val followerCount: Int,val code: CodeView)
