package upcomingmovies.andresmr.com.upcomingmovies.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import upcomingmovies.andresmr.com.upcomingmovies.R
import upcomingmovies.andresmr.com.upcomingmovies.data.entities.Result
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.controllers.UpcomingMoviesController
import upcomingmovies.andresmr.com.upcomingmovies.ui.adapter.UpcomingMoviesListAdapter

class MainActivity : AppCompatActivity() {

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
                setMoviesList(movies)
            }
        }
    }

    fun setMoviesList(movies:List<Result>){
        upcoming_movie_list.adapter = UpcomingMoviesListAdapter(movies){
             navigate<MovieDetailActivity>(it)
        }
    }
}
