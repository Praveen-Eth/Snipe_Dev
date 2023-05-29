package com.augx_universe.snipedev.models

import androidx.lifecycle.MutableLiveData

class Repository {
    var onlineDatabase = FirebaseDatabase()
    suspend fun createPost(feed: Feed, feedBack: (Boolean,Exception?) -> Unit){
        try {
            onlineDatabase.uploadFields(feed)
            feedBack(true,null)
        }catch (e: java.lang.Exception){
            feedBack(false,e)
        }

    }
    suspend fun getLastPostNumber(): Int{
        return onlineDatabase.getLastPostNumber()
    }
}