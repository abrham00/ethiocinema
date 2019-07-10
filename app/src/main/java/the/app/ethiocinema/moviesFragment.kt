package the.app.ethiocinema

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragmentmovies.*
import kotlinx.android.synthetic.main.fragmentmovies.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import the.app.ethiocinema.viewModel.MovieViewModel

class moviesFragment:Fragment (){


    lateinit var recyclerv: RecyclerView
    lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater.inflate( R.layout.fragmentmovies,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch {
            Thread.sleep(2000)
            activity!!.runOnUiThread {
                val movieAdapter= MovieAdapter(activity!!)
                movieViewModel = ViewModelProviders.of(this@moviesFragment).get(MovieViewModel::class.java)
                movieViewModel.allMovies.observe(this@moviesFragment, Observer { movies->
                    movieAdapter.setMovieList(movies)
                })
                recyclerv=view.recycler_view
                recyclerv.layoutManager= GridLayoutManager(activity!!,3)
                recyclerv.adapter=movieAdapter
                val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)
                recyclerv.setLayoutAnimation(controller)
                recyclerv.adapter=movieAdapter
            }
        }

    }
}