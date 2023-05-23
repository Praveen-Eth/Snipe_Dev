package com.augx_universe.snipedev.models

import android.accounts.NetworkErrorException
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class FirebaseDatabase {

    var currentUser  = FirebaseAuth.getInstance().currentUser?.uid
    var fireStoreRef = Firebase.firestore.collection("posts").document(currentUser.toString())


    suspend fun uploadFields(feed: Feed) = CoroutineScope(Dispatchers.IO).launch{

        try {
            fireStoreRef.set(feed).await()
            withContext(Dispatchers.Main){

            }
        }   catch (e: Exception)   {

        }


    }

    suspend fun getLastPostNumber():Int{
       var collectionRef = Firebase.firestore.collection("posts")
        val query = collectionRef.document(currentUser.toString()).get()
        return 1

    }
}