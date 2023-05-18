package com.augx_universe.snipedev.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.augx_universe.snipedev.models.Feed
import com.augx_universe.snipedev.models.Repository

class FeedViewModel: ViewModel() {

    var codeViewText: String  = ""
    var repository : Repository = Repository()

    private var _isFeedUploaded = MutableLiveData<Boolean>()
    var isFeedUploaded: LiveData<Boolean> = _isFeedUploaded

     suspend fun uploadFeed(){
             repository.createPost(Feed(1,codeViewText)).observeForever { _isFeedUploaded.postValue(it) }

    }

}