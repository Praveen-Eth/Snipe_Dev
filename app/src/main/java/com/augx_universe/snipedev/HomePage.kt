package com.augx_universe.snipedev

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.content.ContextCompat

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val menuButton = findViewById<ImageButton>(R.id.menuButton)
        menuButton.setOnClickListener {
            val isHamburger = menuButton.background.constantState?.equals(
                ContextCompat.getDrawable(this, R.drawable.ham)?.constantState
            ) ?: false

            if (isHamburger) {
                menuButton.setImageResource(R.drawable.iconx)

                val rotateAnimator = ObjectAnimator.ofFloat(menuButton, "rotation", 0f, 90f)
                rotateAnimator.duration = 200
                rotateAnimator.start()
                System.out.println("if statement working")
            } else {
                val hamburger = ContextCompat.getDrawable(this, R.drawable.ham)
                menuButton.setImageDrawable(hamburger)

                val rotateAnimator = ObjectAnimator.ofFloat(menuButton, "rotation", 90f, 0f)
                rotateAnimator.duration = 200
                rotateAnimator.start()

                System.out.println("else statement working")
            }
        }
    }
}