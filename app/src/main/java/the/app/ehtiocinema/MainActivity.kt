package the.app.ehtiocinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cinema_ID.setOnClickListener {


            Toast.makeText(this, "Cinemas", Toast.LENGTH_SHORT ).show()
        }
        movies_ID.setOnClickListener {

            val intent = Intent(this, MainMovies::class.java)
            startActivity(intent)
            Toast.makeText(this, "Movies", Toast.LENGTH_SHORT ).show()
        }

        Schedule_iD.setOnClickListener {

            val intent = Intent(this, MainMovies::class.java)
            startActivity(intent)
            Toast.makeText(this, "Daily Schedule", Toast.LENGTH_SHORT).show()
        }
    }
}
