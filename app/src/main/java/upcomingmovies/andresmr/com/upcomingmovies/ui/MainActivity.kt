package upcomingmovies.andresmr.com.upcomingmovies.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import upcomingmovies.andresmr.com.upcomingmovies.R
import upcomingmovies.andresmr.com.upcomingmovies.data.entities.Result
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.controllers.UpcomingMoviesController

class MainActivity : AppCompatActivity(), AnkoLogger, ActivityExtensions{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        upcoming_movie_list.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()

        val movieController = UpcomingMoviesController()
        doAsync {
            val movies = movieController.getUpcomingMovies()
            uiThread {
                navigate<MovieDetailActivity>(movies[0])
            }
        }
    }

    inline fun <reified T : Activity> Activity.navigate(movie: Result? = null) {
        val intent = Intent(this, T::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)
    }
}
