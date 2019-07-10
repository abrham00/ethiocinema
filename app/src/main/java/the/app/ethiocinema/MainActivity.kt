package the.app.ethiocinema


import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragmenthome.*
import kotlinx.android.synthetic.main.one_cinema_view.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import the.app.ethiocinema.ViewPagerAdapter
import the.app.ethiocinema.data.*
import the.app.ethiocinema.repository.CinemaRepo
import the.app.ethiocinema.repository.MovieRepo
import the.app.ethiocinema.repository.ScheduleRepo

class MainActivity : AppCompatActivity() {
    val act: Activity =this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db1= db.getDatabase(applicationContext)
        val movieDao=db1.movieDao()
        val scheduleDao=db1.scheduleDao()
        val cinemaDao=db1.cinemaDao()
        val cinemaRepo=CinemaRepo(cinemaDao)
        val scheduleRepo=ScheduleRepo(scheduleDao)
        val movieRepo= MovieRepo(movieDao)


        GlobalScope.launch{
            movieRepo.clear()
            cinemaRepo.clear()
            scheduleRepo.clear()
            var moviesList: List<Movie>?=null
            var cinemaList: List<Cinema>?=null
            var scheduleList: List<Schedule>?=null
            try {
                moviesList=movieRepo.getMoviesFromNet().execute().body()
                cinemaList=cinemaRepo.getCinemaFromNet().execute().body()
                scheduleList=scheduleRepo.getScheduleFromNet().execute().body()
            }
            catch (ex:Exception){
                runOnUiThread{
                    Toast.makeText(act,"Connection Error...",Toast.LENGTH_LONG).show()
                }
            }
            if (moviesList!=null){
                for (movie in moviesList){
                    movieRepo.Save(movie)
                }

            }
            if (cinemaList!=null){
                for(cinema in cinemaList){
                    cinemaRepo.Save(cinema)
                }
            }
            if (scheduleList!=null){
                for(schedule in scheduleList){
                    scheduleRepo.Save(schedule)
                }
            }

            /*

            cinemaRepo.Save(Cinema("Alem Cinema","Around Bole","www.alemcinema.com.et","+251911468234"))
            cinemaRepo.Save(Cinema("Edna Cinema","Around Bole","www.alemcinema.com.et","+251911468234"))
            cinemaRepo.Save(Cinema("Century Cinema","Around Bole","www.alemcinema.com.et","+251911468234"))
            cinemaRepo.Save(Cinema("New Cinema Cinema","Around Bole","www.alemcinema.com.et","+251911468234"))


            scheduleRepo.Save(Schedule("Alem","x","x","x","re","erg","reg","gr","gre","reg","er","gre","reg"))
            scheduleRepo.Save(Schedule("Sebastopol","22rftyj","yrger,","reerg","ert6y","","eee","reg","re","eg","grerg","erg","oij"))
            scheduleRepo.Save(Schedule("D","x","x","x","re","erg","reg","gr","gre","reg","er","gre","reg"))
            scheduleRepo.Save(Schedule("Asdfm","x","x","x","re","erg","reg","gr","gre","reg","er","gre","reg"))

            movieRepo.Save(Movie(1,"Test","123"))
            movieRepo.Save(Movie(2,"Test","123"))
            movieRepo.Save(Movie(4,"Test","123"))
            movieRepo.Save(Movie(5,"Test","123"))
            movieRepo.Save(Movie(6,"Test","123"))
            movieRepo.Save(Movie(7,"Test","123"))
            movieRepo.Save(Movie(8,"Test","123"))
            movieRepo.Save(Movie(9,"Test","123"))
            movieRepo.Save(Movie(10,"Test","123"))*/
        }
    }
    fun toCinemaDetail(view: View){
        val name="Alem Cinema"
        var bundle= bundleOf("cinemaname" to name)
        val navController1 = Navigation.findNavController(this, R.id.main_frame)
        navController1.navigate(R.id.action_mainFragment_to_cinemaDetail,bundle)

    }
}
