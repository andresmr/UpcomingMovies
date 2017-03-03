package upcomingmovies.andresmr.com.upcomingmovies.data.repository

interface Factory<T> {
    fun get(): T
}