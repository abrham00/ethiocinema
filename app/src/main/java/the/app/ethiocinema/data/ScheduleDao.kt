package the.app.ethiocinema.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScheduleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSc(sc:Schedule):Long

    @Query("Select * from Schedule")
    fun getSc():LiveData<List<Schedule>>

    @Query("Delete from schedule")
    fun clear()
}
