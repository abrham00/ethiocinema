package the.app.ethiocinema.viewModel

import android.app.Application
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import retrofit2.Call
import the.app.ethiocinema.data.Movie
import the.app.ethiocinema.data.db
import the.app.ethiocinema.repository.MovieRepo

class MovieViewModel(application: Application) : AndroidViewModel(application)  {
    private val movieRepo: MovieRepo
    val allMovies:LiveData<List<Movie>>
    init {
        val movieda= db.getDatabase(application).movieDao()
        movieRepo=MovieRepo(movieda)
        allMovies=movieRepo.getMovies()
    }
    fun getMovieFromNet(): Call<List<Movie>> {
        return movieRepo.getMoviesFromNet()
    }
    fun Save(mov: Movie):Long{
        return movieRepo.Save(mov)
    }
}
