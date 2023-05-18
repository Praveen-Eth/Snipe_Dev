package com.augx_universe.snipedev.view_models

import androidx.lifecycle.*
import com.augx_universe.snipedev.models.Feed
import com.augx_universe.snipedev.models.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FeedViewModel: ViewModel() {

    var codeViewText: String  = ""
    var repository : Repository = Repository()

    private var _isFeedUploaded = MutableLiveData<Boolean>()
    var isFeedUploaded: LiveData<Boolean> = _isFeedUploaded

      fun uploadFeed(){

         viewModelScope.launch {

             repository.createPost(Feed(1,codeViewText.toString())).observeForever { _isFeedUploaded.postValue(it) }
         }

    }

}