package com.example.themetapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.themetapp.R
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.network.ApiService
import com.example.themetapp.viewmodels.HomeViewModel

class OnboardingStepOnePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_step_one)

        val btn = findViewById<Button>(R.id.btn_navigate_to_step_2)


        btn.setOnClickListener {
            val intent = Intent(
                this@OnboardingStepOnePage, OnboardingStepTwoPage::class.java
            )
            startActivity(intent)
        }
    }
}