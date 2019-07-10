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
import the.app.ethiocinema.data.Movie


class MovieAdapter(val context:Context): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var moviesL:List<Movie> = emptyList()

    internal fun setMovieList(movies:List<Movie>){
        this.moviesL=movies
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        val inflater=LayoutInflater.from(p0.context)
        val recyclerViewItem=inflater.inflate(R.layout.one_movie_view,p0,false)
        return MovieViewHolder(recyclerViewItem)
    }

    override fun getItemCount(): Int {
        return moviesL.size
    }

    override fun onBindViewHolder(p0: MovieViewHolder, p1: Int) {
        val mov=moviesL[p1]
        Picasso.get()
            .load(mov.imagelink+".jpg")
            .fit()
            .into(p0.itemView.one_movie_image);
        p0.itemView.one_movie_title.text=mov.name


    }
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}