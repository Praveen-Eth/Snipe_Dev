package com.augx_universe.snipedev

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var currentUser: FirebaseUser
    private lateinit var mAuth:FirebaseAuth
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            mAuth = FirebaseAuth.getInstance()
            val executor = Executors.newSingleThreadScheduledExecutor()
        executor.schedule({
            var intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        },3000,TimeUnit.MILLISECONDS)

    }
}