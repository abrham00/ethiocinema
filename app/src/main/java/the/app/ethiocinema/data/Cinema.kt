package the.app.ethiocinema.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Cinema(@PrimaryKey val name:String,
             val location:String,
             val weblink:String,
             val phone:String) {
}