package upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.controllers
import retrofit2.Call
import upcomingmovies.andresmr.com.upcomingmovies.data.entities.Result
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.MoviesNetService
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.NetworkUtils

class UpcomingMoviesController{

    fun getUpcomingMovies() : List<Result> =
            MoviesNetService.get().getUpComingMovies(NetworkUtils.API_KEY).unwrapCall { return results }
}

inline fun <T, U> Call<T>.unwrapCall(f: T.() -> U) = execute().body().f()
