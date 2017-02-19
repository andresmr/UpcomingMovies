package upcomingmovies.andresmr.com.upcomingmovies.data.repository.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.Factory

class MoviesNetService(){

    companion object : Factory<MoviesApi> {
        override fun get(): MoviesApi = Retrofit
                .Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(MoviesApi::class.java)
    }
}