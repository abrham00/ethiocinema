package the.app.ehtiocinema

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.acitivity_movies.*


class MainMovies : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_movies)

val layoutManager = LinearLayoutManager (this)
layoutManager.orientation =LinearLayoutManager.VERTICAL
recyclerView.layoutManager = layoutManager



  val adapter = FilmAdapter(this, Films.films )
recyclerView.adapter = adapter
    }
}