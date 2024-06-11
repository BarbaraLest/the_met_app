package com.example.themetapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.themetapp.R

class OnboardingStepThreePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_step_three)
        val btn = findViewById<Button>(R.id.btn_navigate_to_home)


        btn.setOnClickListener {
            val intent = Intent(
                this@OnboardingStepThreePage,
                HomePage::class.java
            )
            startActivity(intent)
        }


    }
}