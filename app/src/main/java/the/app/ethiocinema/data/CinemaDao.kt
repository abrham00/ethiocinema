package the.app.ethiocinema.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CinemaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCinema(cinema: Cinema):Long

    @Query("select * from Cinema")
    fun getCinema() : LiveData<List<Cinema>>

    @Query("Delete from Cinema ")
    fun clear()

    @Query("select * from Cinema where name=:name")
    fun getInfo(name: String): LiveData<Cinema>
}