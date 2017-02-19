package upcomingmovies.andresmr.com.upcomingmovies.data.entities

class UpcomingMovies(val page: Int, val results: List<Result>, val dates: Dates,
                          val totalPages: Int, val totalResults: Int)