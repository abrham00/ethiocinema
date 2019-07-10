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
import kotlinx.android.synthetic.main.fragmentschedule.view.*
import the.app.ethiocinema.data.Schedule
import the.app.ethiocinema.viewModel.ScheduleViewModel


class scheduleFragment: Fragment(){
    lateinit var recyclerv1: RecyclerView

    lateinit var scViewModel: ScheduleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater.inflate( R.layout.fragmentschedule,container,false)
        val scAdapter= ScheduleAdapter(activity!!)
        scViewModel = ViewModelProviders.of(this).get(ScheduleViewModel::class.java)
        scViewModel.allSchedule.observe(this, Observer { schedule->
            scAdapter.setList(schedule)
        })
        recyclerv1=view.sch_recycler
        recyclerv1.layoutManager=LinearLayoutManager(activity!!)
        recyclerv1.adapter=scAdapter
        val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)
        recyclerv1.setLayoutAnimation(controller)
        recyclerv1.adapter=scAdapter
        return view
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }
}