package com.example.themetapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.themetapp.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnMain)

        btn.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                OnboardingStepOnePage::class.java
            )
            startActivity(intent)
        }
    }
}