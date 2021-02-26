package com.form.tbdbclient.data.repository

import android.util.Log
import com.form.tbdbclient.data.model.movie.Movie
import com.form.tbdbclient.data.model.movie.MovieList
import com.form.tbdbclient.data.repository.movie.dataSource.MovieCacheDataSource
import com.form.tbdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.form.tbdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.form.tbdbclient.domain.repository.MovieRepository

class MoviRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource,
                         private val movieLocalDataSource: MovieLocalDataSource,
                         private val movieCacheDataSource: MovieCacheDataSource
                         ) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovie : List<Movie> = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovie)
        movieCacheDataSource.saveMoviesToCache(newListOfMovie)
        return newListOfMovie
    }

    suspend fun getMoviesFromApi() : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body : MovieList? = response.body()
            if (body != null){
                movieList = body.movies
            }
        }catch (exception : Exception){
            Log.i("MyTag:", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromLocalDb() : List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception : Exception){
            Log.i("MyTag:", exception.message.toString())
        }

        if (movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (ex : Exception){
            Log.i("MyTag:", ex.message.toString())
        }
        if (movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromLocalDb()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}