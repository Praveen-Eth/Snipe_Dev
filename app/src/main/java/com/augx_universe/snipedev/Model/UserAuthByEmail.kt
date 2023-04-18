package com.augx_universe.snipedev.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth


class UserAuthByEmail {
    private var mAuth: FirebaseAuth  = FirebaseAuth.getInstance()

    fun createNewUser(email: String, password: String):LiveData<Boolean>{

        var isSuccess: MutableLiveData<Boolean>  = MutableLiveData<Boolean>()
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            isSuccess.postValue(task.isSuccessful)
        }
        return isSuccess
    }
    fun signInUsingEmailPassword(email: String,password: String): MutableLiveData<Boolean>{
         val isSuccess: MutableLiveData<Boolean>   = MutableLiveData<Boolean>()
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            isSuccess.postValue( task.isSuccessful)
            System.out.println(isSuccess.postValue(task.isSuccessful));
        }
        return isSuccess
    }


}