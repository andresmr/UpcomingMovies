package upcomingmovies.andresmr.com.upcomingmovies.data.repository.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import upcomingmovies.andresmr.com.upcomingmovies.data.entities.UpcomingMovies

interface MoviesApi {

    @GET("3/movie/upcoming")
    fun getUpComingMovies(@Path("api_key") apiKey: String): Call<UpcomingMovies>
}