package com.example.themetapp.views

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.themetapp.R
import com.example.themetapp.models.ObjectModel
import java.net.URL

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
            txtObjectTitle.text = objectItem.title
            txtArtistName.text = objectItem.artistDisplayName
            txtObjectYear.text = objectItem.objectEndDate.toString()
            txtObjectCulture.text = objectItem.culture
            txtObjectClassification.text = objectItem.classification

            val url: URL = URL(objectItem.primaryImage);
            var image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            primaryImage.setImageBitmap(image)


        }


    }
}