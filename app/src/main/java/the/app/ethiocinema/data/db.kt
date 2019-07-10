package the.app.ethiocinema.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Movie::class,Cinema::class,Schedule::class),version=8)
abstract class db: RoomDatabase() {
    abstract fun movieDao():MovieDao
    abstract fun scheduleDao() :ScheduleDao
    abstract fun cinemaDao():CinemaDao

    companion object {
        @Volatile
        private var INSTANCE :db?=null

        fun getDatabase(context: Context):db{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    db::class.java,"cine_database")
                    .fallbackToDestructiveMigration()
                    .build()
                return instance
            }
        }
    }
}