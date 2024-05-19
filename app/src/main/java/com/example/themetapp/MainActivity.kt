package com.example.themetapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.themetapp.datasources.MetMuseumRemoteDatasource
import com.example.themetapp.network.services

class MainActivity : AppCompatActivity() {
    companion object{
        val apiService by lazy { services() }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button2)
        btn.setOnClickListener{
            MetMuseumRemoteDatasource(apiService).getObjectById{ item, error ->
                Toast.makeText(this,  "{$item.artistDisplayName}", Toast.LENGTH_LONG).show()

            }
        }
    }
}