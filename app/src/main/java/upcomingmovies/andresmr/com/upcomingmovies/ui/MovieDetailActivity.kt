package upcomingmovies.andresmr.com.upcomingmovies.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*
import org.jetbrains.anko.AnkoLogger
import upcomingmovies.andresmr.com.upcomingmovies.R
import upcomingmovies.andresmr.com.upcomingmovies.data.entities.Result

class MovieDetailActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val movie : Result? = intent.getSerializableExtra("movie") as? Result
        movie_title.text = movie?.title
    }
}
