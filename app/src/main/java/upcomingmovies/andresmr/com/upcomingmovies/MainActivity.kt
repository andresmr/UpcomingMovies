package upcomingmovies.andresmr.com.upcomingmovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.controllers.UpcomingMoviesController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //    upcoming_movie_list.layoutManager
    }

    override fun onResume() {
        super.onResume()

        val movieController = UpcomingMoviesController()
        doAsync {
            val movies = movieController.getUpcomingMovies()
        }
    }
}
