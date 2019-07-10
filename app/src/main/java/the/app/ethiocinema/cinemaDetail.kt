package the.app.ethiocinema


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.cinema_detail_view.view.*
import kotlinx.android.synthetic.main.schedule_table.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import the.app.ethiocinema.data.Cinema
import the.app.ethiocinema.data.db
import the.app.ethiocinema.databinding.CinemaDetailViewBinding
import the.app.ethiocinema.repository.CinemaRepo
import the.app.ethiocinema.viewModel.CinemaViewModel

class cinemaDetail:Fragment (){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val detailBinding=DataBindingUtil.inflate<CinemaDetailViewBinding>(inflater, R.layout.cinema_detail_view,container, false)
        val view= inflater.inflate( R.layout.cinema_detail_view,container,false)
        val idS=arguments?.getString("cinemaname")
        val cinemaViewModel=ViewModelProviders.of(this).get(CinemaViewModel::class.java)
        cinemaViewModel.getByName(idS!!).observe(this, Observer {
            detailBinding.oneCinema=it!!
        })
        return detailBinding.root
    }
}