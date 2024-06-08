package com.example.themetapp.views;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themetapp.R;


public class OnboardingStepOnePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_step_one);

        Button btnNavigateToStep2 = findViewById(R.id.btn_navigate_to_step_2);
        btnNavigateToStep2.setOnClickListener(v -> {
            Intent intent = new Intent(OnboardingStepOnePage.this, OnboardingStepTwoPage.class);
            startActivity(intent);
        });


    }
}
