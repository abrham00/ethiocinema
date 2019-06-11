package the.app.ehtiocinema

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movielist.view.*

class  FilmAdapter (val context: Context, val films: List<Film> ) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {

val view= LayoutInflater.from(context).inflate(R.layout.movielist, parent,false)
   return FilmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return films.size

    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {

   val film = films[position]
        holder.setData(film, position)

    }

    inner  class FilmViewHolder ( itemView: View ) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {


            }
        }
fun  setData (film: Film?, pos: Int)  {

    itemView.movieTitle.text = film!!.title
}

    }
}