package com.augx_universe.snipedev.models

import android.accounts.NetworkErrorException
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FirebaseDatabase {

    var currentUser  = FirebaseAuth.getInstance().currentUser?.uid
    var fireStoreRef = Firebase.firestore.collection("posts").document(currentUser.toString())


    suspend fun uploadFields(feed: Feed):MutableLiveData<Boolean>{
        var isSuccess = MutableLiveData<Boolean>()


        fireStoreRef.set(feed).addOnCompleteListener {task-> isSuccess.postValue(task.isSuccessful) }
            return isSuccess


    }

    suspend fun getLastPostNumber():Int{
       var collectionRef = Firebase.firestore.collection("posts")
        val query = collectionRef.document(currentUser.toString()).get()
        return 1

    }
}