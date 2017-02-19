package upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.controllers

import upcomingmovies.andresmr.com.upcomingmovies.data.entities.UpcomingMovies
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.MoviesNetService
import upcomingmovies.andresmr.com.upcomingmovies.data.repository.network.NetworkUtils

class UpcomingMoviesController(){

    fun getUpcomingMovies() = MoviesNetService.get().getUpComingMovies(NetworkUtils.API_KEY).execute()

}
