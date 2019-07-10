package the.app.ethiocinema.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Movies")
class Movie(
    @PrimaryKey val mid: Int,
    val name: String,
    val imagelink:String):Serializable {

}