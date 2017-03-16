package upcomingmovies.andresmr.com.upcomingmovies.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.widget.TextView
import org.jetbrains.anko.textColor
import upcomingmovies.andresmr.com.upcomingmovies.data.entities.Result

inline fun <reified T : Activity> Activity.navigate(movie: Result? = null) {
    val intent = Intent(this, T::class.java)
    intent.putExtra("movie", movie)
    startActivity(intent)
}

fun TextView.showMovieHeader(movie: Result?) {
    textColor = Color.BLACK
    textSize = 20f
    val headerTitle = movie?.title + " - " + movie?.popularity
    text = headerTitle

}

fun TextView.showMovieContent(movie: Result?) {
    text = movie?.overview
}