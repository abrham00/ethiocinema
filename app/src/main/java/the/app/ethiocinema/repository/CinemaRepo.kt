package the.app.ethiocinema.repository

import androidx.lifecycle.LiveData
import retrofit2.Call
import the.app.ethiocinema.data.Cinema
import the.app.ethiocinema.data.CinemaDao
import the.app.ethiocinema.data.Schedule
import the.app.ethiocinema.data.ScheduleDao
import the.app.ethiocinema.net.netService

class CinemaRepo (private val cinemaDao: CinemaDao) {
    val api: netService =netService.getInstance()
    fun Save(cinema:Cinema): Long {
        return cinemaDao.insertCinema(cinema)
    }
    fun getCinemas(): LiveData<List<Cinema>> {
        return cinemaDao.getCinema()
    }
    fun getByName(name:String):LiveData<Cinema>{
        return cinemaDao.getInfo(name)
    }
    fun getCinemaFromNet(): Call<List<Cinema>> {
        return api.getCinemas()
    }
    fun clear(){
        cinemaDao.clear()
    }
}