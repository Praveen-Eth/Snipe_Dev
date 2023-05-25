package com.augx_universe.snipedev.models

import androidx.lifecycle.MutableLiveData

class Repository {
    var onlineDatabase = FirebaseDatabase()
    suspend fun createPost(feed: Feed){
        onlineDatabase.uploadFields(feed)
    }
    suspend fun getLastPostNumber(): Int{
        return onlineDatabase.getLastPostNumber()
    }
}