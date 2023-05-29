package com.augx_universe.snipedev.view_models

import androidx.lifecycle.*
import com.augx_universe.snipedev.models.Feed
import com.augx_universe.snipedev.models.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FeedViewModel: ViewModel() {

    var codeViewText: String  = ""
    var repository : Repository = Repository()



      fun uploadFeed(feedBack: (Boolean,Exception?) -> Unit){

         viewModelScope.launch {

             repository.createPost(Feed(1,codeViewText.toString())){
                     Success,Exception ->
                 feedBack(Success,Exception)
             }
         }

    }

}