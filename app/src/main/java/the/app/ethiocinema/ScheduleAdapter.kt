package the.app.ethiocinema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.schedule_table.view.*
import the.app.ethiocinema.data.Schedule

class ScheduleAdapter(val context: Context): RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {


    private var moviesL:List<Schedule> = emptyList()

    fun setList(lst:List<Schedule>){
        this.moviesL=lst
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val recyclerViewItem=inflater.inflate(R.layout.schedule_table,parent,false)
        return ScheduleViewHolder(recyclerViewItem)
    }

    override fun getItemCount(): Int {
        return moviesL.size
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val mov=moviesL[position]
        holder.itemView.d16.text=mov.d16
        holder.itemView.d18.text=mov.d18
        holder.itemView.d110.text=mov.d110
        holder.itemView.d112.text=mov.d112
        holder.itemView.d26.text=mov.d26
        holder.itemView.d28.text=mov.d28
        holder.itemView.d210.text=mov.d210
        holder.itemView.d212.text=mov.d212
        holder.itemView.d36.text=mov.d36
        holder.itemView.d38.text=mov.d38
        holder.itemView.d310.text=mov.d310
        holder.itemView.d312.text=mov.d312
        holder.itemView.cinema_name.text=mov.cinemaname
    }


    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}