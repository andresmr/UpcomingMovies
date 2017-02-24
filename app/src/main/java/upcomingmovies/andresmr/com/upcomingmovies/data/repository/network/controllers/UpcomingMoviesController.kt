package upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.controllers
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import upcomingmovies.andresmr.com.upcomingmovies.data.entities.Result
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.MoviesNetService
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.NetworkUtils
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.NetworkUtils.Companion.ON_FAILURE
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.NetworkUtils.Companion.RETROFIT

class UpcomingMoviesController{

    fun getUpcomingMovies() : List<Result> =
            MoviesNetService.get().getUpComingMovies(NetworkUtils.API_KEY).unwrapCall { return results }

    fun getUpcomingMoviesWithCallbacks() {
    //    MoviesNetService.get().getUpComingMovies(NetworkUtils.API_KEY).enqueue{onSuccess = {}, onFailure = {} }
    }

}

fun <T> Call<T>.enqueue(success: (responseBody: Response<T>) -> Unit,
                                failure: (t: Throwable) -> Unit) {
    enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            if (response!!.isSuccessful) success(response)
        }

        override fun onFailure(call: Call<T>?, t: Throwable?) {
            failure(t!!)
            Log.d(RETROFIT, ON_FAILURE)
        }
    })
}

inline fun <T, U> Call<T>.unwrapCall(f: T.() -> U) = execute().body().f()
inline fun <T, U> Response<T>.unwrapResponse(f: T.() -> U) = body().f()
