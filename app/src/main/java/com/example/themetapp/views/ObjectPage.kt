package com.example.themetapp.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.themetapp.R
import com.example.themetapp.models.ObjectModel

class ObjectPage : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.object_page)

        val objectItem = intent.getParcelableExtra<ObjectModel>("objectModel")

        val txtObjectTitle: TextView = findViewById(R.id.object_title)
        val txtArtistName: TextView = findViewById(R.id.object_artist_name)
        val txtObjectYear: TextView = findViewById(R.id.object_year)
        val txtObjectCulture: TextView = findViewById(R.id.object_culture)
        val txtObjectClassification: TextView = findViewById(R.id.object_classification)
        val primaryImage: ImageView = findViewById(R.id.object_primary_img)


        if (objectItem != null) {
            txtObjectTitle.text = if (objectItem.title == "") "no information" else objectItem.title
            txtArtistName.text =
                if (objectItem.artistDisplayName == "") "no information" else objectItem.artistDisplayName
            txtObjectYear.text =
                if (objectItem.objectEndDate.toString() == "") "no information" else objectItem.objectEndDate.toString()
            txtObjectCulture.text =
                if (objectItem.culture == "") "no information" else objectItem.culture
            txtObjectClassification.text =
                if (objectItem.classification == "") "no information" else objectItem.classification

            Glide.with(this)
                .load(objectItem.primaryImage)
                .placeholder(R.drawable.loading_image)
                .error(R.drawable.default_avatar)
                .into(primaryImage)


        }


    }
}