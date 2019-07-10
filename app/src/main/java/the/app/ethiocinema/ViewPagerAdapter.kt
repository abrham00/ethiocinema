package the.app.ethiocinema

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class ViewPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        var fragment:Fragment?=null

        if(position==0)
        {
            fragment=HomeFragment()

        }

        else if (position==1)

        {
            fragment=moviesFragment()

        }

        else if (position==2)
        {

            fragment=scheduleFragment()

        }
        else if (position==3)
        {

            fragment=cinemaListFragment()

        }
        return fragment
    }

    override fun getCount(): Int {

        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title:String?=null
        if (position==0)
        {

            title="HOME"

        }

        else if (position==1)
        {

            title="MOVIES"

        }
        else if (position==2)
        {
            title="SCHEDULE"
        }

        else if (position==3)
        {
            title="CINEMA"
        }


        return title

    }



}