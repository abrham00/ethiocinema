package the.app.ethiocinema.repository

import androidx.lifecycle.LiveData
import retrofit2.Call
import the.app.ethiocinema.data.Cinema
import the.app.ethiocinema.data.Schedule
import the.app.ethiocinema.data.ScheduleDao
import the.app.ethiocinema.net.netService


class ScheduleRepo (private val scdao: ScheduleDao){
    val api=netService.getInstance()
    fun Save(sc:Schedule): Long {
        return scdao.insertSc(sc)
    }
    fun getSC(): LiveData<List<Schedule>> {
        return scdao.getSc()
    }
    fun getScheduleFromNet(): Call<List<Schedule>> {
        return api.getSchedule()
    }
    fun clear(){
        scdao.clear()
    }
}