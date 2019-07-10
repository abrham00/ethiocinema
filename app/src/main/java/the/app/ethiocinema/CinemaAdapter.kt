package the.app.ethiocinema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.one_movie_view.view.*
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.one_cinema_view.view.*
import the.app.ethiocinema.data.Cinema
import the.app.ethiocinema.data.Movie


class CinemaAdapter(val context:Context): RecyclerView.Adapter<CinemaAdapter.CinemaViewHolder>() {

    private var cinemaL:List<Cinema> = emptyList()

    internal fun setCinemaList(cinemaL:List<Cinema>){
        this.cinemaL=cinemaL
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CinemaViewHolder {
        val inflater=LayoutInflater.from(p0.context)
        val recyclerViewItem=inflater.inflate(R.layout.one_cinema_view,p0,false)
        return CinemaViewHolder(recyclerViewItem)
    }

    override fun getItemCount(): Int {
        return cinemaL.size
    }

    override fun onBindViewHolder(p0: CinemaViewHolder, p1: Int) {
        val mov=cinemaL[p1]
        p0.itemView.cinema_na.text=mov.name


    }
    class CinemaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}