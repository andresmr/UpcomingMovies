package upcomingmovies.andresmr.com.upcomingmovies.data.repository.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import upcomingmovies.andresmr.com.upcomingmovies.data.entities.UpcomingMovies

interface MoviesApi {

    @GET("3/movie/upcoming")
    fun getUpComingMovies(@Query("api_key") apiKey: String): Call<UpcomingMovies>
}