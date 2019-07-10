package the.app.ethiocinema.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import retrofit2.Call
import the.app.ethiocinema.data.Cinema
import the.app.ethiocinema.data.db
import the.app.ethiocinema.repository.CinemaRepo

class CinemaViewModel(application: Application) : AndroidViewModel(application)  {
    private val cinemaRepo:CinemaRepo
    val allMovies: LiveData<List<Cinema>>
    init {
        val cinemaDao= db.getDatabase(application).cinemaDao()
        cinemaRepo=CinemaRepo(cinemaDao)
        allMovies=cinemaRepo.getCinemas()
    }
  /*  fun getCinemasFromNet(): Call<List<Cinema>> {
        return cinemaRepo.getAllMoviesFromNet()
    }*/
    fun Save(cinema:Cinema):Long{
        return cinemaRepo.Save(cinema)
    }
    fun getByName(name:String):LiveData<Cinema>{
        return cinemaRepo.getByName(name)
    }
}
