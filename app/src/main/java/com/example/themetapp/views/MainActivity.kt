package com.example.themetapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.themetapp.R


class MainActivity : AppCompatActivity() {
//    companion object{
//        val apiService by lazy { services() }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val btn = findViewById<Button>(R.id.button2)
//        btn.setOnClickListener{
//            MetMuseumRemoteDatasource(apiService).getObjectById{ item, error ->
//                val name = item?.artistDisplayName
//                Toast.makeText(this,  name, Toast.LENGTH_LONG).show()
//
//            }
//        }
        val btnMain = findViewById<Button>(R.id.btnMain)

        btnMain.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                OnboardingStepOnePage::class.java
            )
            startActivity(intent)
        }
    }
}