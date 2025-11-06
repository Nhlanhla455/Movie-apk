package com.example.movieapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class DetailedScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailedscreen)

        // Receive data from MainScreen
        val titles = intent.getStringArrayExtra("titles")
        val directors = intent.getStringArrayExtra("directors")
        val ratings = intent.getIntArrayExtra("ratings")
        val comments = intent.getStringArrayExtra("comments")

        val listView: ListView = findViewById(R.id.movieListView)
        val btnBack: Button = findViewById(R.id.btnBack)

        // Create a list to display all movie details
        val detailsList = ArrayList<String>()
        if (titles != null && directors != null && ratings != null && comments != null) {
            for (i in titles.indices) {
                val detail = """
                    🎬 Title: ${titles[i]}
                    🎥 Director: ${directors[i]}
                    ⭐ Rating: ${ratings[i]}/5
                    💬 Comment: ${comments[i]}
                """.trimIndent()
                detailsList.add(detail)
            }
        }

        // Display movie details in a ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, detailsList)
        listView.adapter = adapter

        // Button to go back to the main screen
        btnBack.setOnClickListener {
            finish()
        }
    }
}
