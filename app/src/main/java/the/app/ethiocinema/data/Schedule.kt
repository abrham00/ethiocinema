package the.app.ethiocinema.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Schedule(@PrimaryKey val cinemaname:String,
               val d16:String,
               val d18:String,
               val d110:String,
               val d112:String,
               val d26:String,
               val d28:String,
               val d210:String,
               val d212:String,
               val d36:String,
               val d38:String,
               val d310:String,
               val d312:String) {
}