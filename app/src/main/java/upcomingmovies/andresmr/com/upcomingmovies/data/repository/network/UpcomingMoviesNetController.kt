package upcomingmovies.andresmr.com.upcomingmovies.data.repository.network

class UpcomingMoviesNetController(val language:String, val page:String){

    // response here https://developers.themoviedb.org/3/movies/get-upcoming

    companion object{
        private val BASE_URL = "https://api.themoviedb.org/3/movie/upcoming?api_key="
        private val API_KEY = "ef7207d60c949efbe23d1d2c0d580eb2"
    }

}
