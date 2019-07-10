package the.app.ethiocinema.repository

import androidx.lifecycle.LiveData
import retrofit2.Call
import the.app.ethiocinema.data.Cinema
import the.app.ethiocinema.data.Movie
import the.app.ethiocinema.data.MovieDao
import the.app.ethiocinema.net.netService

class MovieRepo(private val movieDao: MovieDao) {
    val api:netService= netService.getInstance()
    fun Save(mov: Movie): Long {
        return movieDao.insertMovie(mov)
    }
    fun getMovies():LiveData<List<Movie>>{
        return movieDao.getMovies()
    }
    fun getMoviesFromNet(): Call<List<Movie>> {
        return api.getAllMoviesFromNet()
    }
    fun clear(){
        movieDao.ClearAllMovies()
    }
}