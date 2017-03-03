package upcomingmovies.andresmr.com.upcomingmovies.data.repository.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.Factory

class MoviesNetService{

    companion object : Factory<MoviesApi> {
        val interceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val baseURL = "https://api.themoviedb.org/"

        override fun get(): MoviesApi = Retrofit
                .Builder()
                .client(httpClient)
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(MoviesApi::class.java)
    }
}