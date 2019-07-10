package the.app.ethiocinema
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragmenthome.*

class HomeFragment:Fragment (){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate( R.layout.fragmenthome,container,false)



    }
}