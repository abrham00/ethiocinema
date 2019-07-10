package the.app.ethiocinema.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import the.app.ethiocinema.data.Schedule
import the.app.ethiocinema.data.db
import the.app.ethiocinema.repository.ScheduleRepo

class ScheduleViewModel(application: Application) : AndroidViewModel(application)   {
    private val scRepo: ScheduleRepo
    var allSchedule: LiveData<List<Schedule>>
    init {
        val scda= db.getDatabase(application).scheduleDao()
        scRepo=ScheduleRepo(scda)
        allSchedule=scRepo.getSC()
    }
}