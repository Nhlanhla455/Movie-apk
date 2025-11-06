package com.example.movieapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainScreen : AppCompatActivity() {

    // Parallel arrays for movie info
    private val movieTitles = arrayListOf("The Godfather", "Inception", "Titanic")
    private val movieDirectors = arrayListOf("Francis Ford Coppola", "Christopher Nolan", "James Cameron")
    private val movieRatings = arrayListOf(5, 4, 3)
    private val movieComments = arrayListOf("Masterpiece", "Mind-bending", "Classic")

    private lateinit var avgRatingText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen)

        val btnAddMovie: Button = findViewById(R.id.btnAddMovie)
        val btnViewReviews: Button = findViewById(R.id.btnViewReviews)
        avgRatingText = findViewById(R.id.avgRatingText)

        // Calculate average rating initially
        updateAverageRating()

        // Button 1: Add Movie (adds new movie data to arrays)
        btnAddMovie.setOnClickListener {
            addNewMovie()
        }

        // Button 2: View Reviews (navigates to DetailedScreen)
        btnViewReviews.setOnClickListener {
            val intent = Intent(this, DetailedScreen::class.java)
            intent.putExtra("titles", movieTitles.toTypedArray())
            intent.putExtra("directors", movieDirectors.toTypedArray())
            intent.putExtra("ratings", movieRatings.toIntArray())
            intent.putExtra("comments", movieComments.toTypedArray())
            startActivity(intent)
        }
    }

    private fun addNewMovie() {
        // Simulate adding a new movie (example entry)
        movieTitles.add("Avatar")
        movieDirectors.add("James Cameron")
        movieRatings.add(4)
        movieComments.add("Visually stunning")

        Toast.makeText(this, "New movie added!", Toast.LENGTH_SHORT).show()
        updateAverageRating()
    }

    @SuppressLint("SetTextI18n")
    private fun updateAverageRating() {
        var total = 0
        for (rating in movieRatings) {
            total += rating
        }
        val average = total.toDouble() / movieRatings.size
        avgRatingText.text = "Average Rating: %.1f".format(average)
    }
}
