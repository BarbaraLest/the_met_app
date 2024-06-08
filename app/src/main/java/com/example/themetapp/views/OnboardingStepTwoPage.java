package com.example.themetapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themetapp.R;

public class OnboardingStepTwoPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_step_two);

        Button btnNavigateToStep3 = findViewById(R.id.btn_navigate_to_step_3);
        btnNavigateToStep3.setOnClickListener(v -> {
            Intent intent = new Intent(OnboardingStepTwoPage.this, OnboardingStepThreePage.class);
            startActivity(intent);
        });


    }
}