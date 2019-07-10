package the.app.ethiocinema


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_cinema_list.view.*
import the.app.ethiocinema.viewModel.CinemaViewModel
import the.app.ethiocinema.viewModel.MovieViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class cinemaListFragment : Fragment() {
    lateinit var recyclerv: RecyclerView
    lateinit var cinemaViewModel: CinemaViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cinema_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cinemaAdapter= CinemaAdapter(activity!!)
        cinemaViewModel = ViewModelProviders.of(this).get(CinemaViewModel::class.java)
        cinemaViewModel.allMovies.observe(this, Observer { cinema->
            cinemaAdapter.setCinemaList(cinema)
        })
        recyclerv=view.cinemalistrec
        recyclerv.layoutManager= LinearLayoutManager(activity!!)
        recyclerv.adapter=cinemaAdapter
        val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)
        recyclerv.setLayoutAnimation(controller)
        recyclerv.adapter=cinemaAdapter

    }

    override fun onPause() {
        super.onPause()
        super.onDestroy()
    }
}