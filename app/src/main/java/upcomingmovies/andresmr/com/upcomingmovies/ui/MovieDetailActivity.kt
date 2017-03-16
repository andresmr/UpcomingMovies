package upcomingmovies.andresmr.com.upcomingmovies.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import upcomingmovies.andresmr.com.upcomingmovies.data.entities.Result

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val result : Result? = intent.getSerializableExtra("movie") as? Result

        verticalLayout {
            padding = dip(10)
            textView().showMovieHeader(result)
            textView().showMovieContent(result)
        }

    }
}