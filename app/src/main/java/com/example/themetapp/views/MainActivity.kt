package com.example.themetapp.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.themetapp.R
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.network.services
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    companion object {
        val apiService by lazy { services() }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnMain)

//        btn.setOnClickListener {
//            MetMuseumRemoteDatasource(apiService).getObjectById(5) { item, error ->
//                val name = item?.artistDisplayName
//                Toast.makeText(this, "deu certo", Toast.LENGTH_LONG).show()
//
//
//            }
//
//        }


//        btn.setOnClickListener {
//            MetMuseumRemoteDatasource(apiService).getDepartments { item, error ->
//                val name = item?.departments?.first()?.displayName
//                Toast.makeText(this, name, Toast.LENGTH_LONG).show()
//
//
//            }
//
//        }


        btn.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                OnboardingStepOnePage::class.java
            )
            startActivity(intent)
        }
    }
}