package com.augx_universe.snipedev.entities

data class PollItems(val question: String,val options: List<String>,val votePercentageList: List<Float>) :FeedDataClass()


