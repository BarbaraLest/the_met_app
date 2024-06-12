package com.example.themetapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.themetapp.R
import com.example.themetapp.models.ObjectModel

class ObjectPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.object_page)

        val objectId = intent.getParcelableExtra<ObjectModel>("objectModel")

    }
}