package com.example.themetapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.themetapp.R

class OnboardingStepTwoPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_step_two)

        val btn = findViewById<Button>(R.id.btn_navigate_to_step_3)


        btn.setOnClickListener {
            val intent = Intent(
                this@OnboardingStepTwoPage,
                OnboardingStepThreePage::class.java
            )
            startActivity(intent)
        }
    }
}