package upcomingmovies.andresmr.com.upcomingmovies.data.repository.network

import retrofit2.Call

class NetworkUtils{

    companion object{
        val API_KEY = "ef7207d60c949efbe23d1d2c0d580eb2"
        val RETROFIT = "RETROFIT"
        val ON_FAILURE = "onFailure -> Something went wrong"
    }

    inline fun <T, U> Call<T>.unwrapCall(f: T.() -> U) = execute().body().f()

}