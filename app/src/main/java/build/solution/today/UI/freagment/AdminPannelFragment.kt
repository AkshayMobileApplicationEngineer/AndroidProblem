package build.solution.today.UI.freagment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import build.solution.retrofit.R

/**
 * A simple [Fragment] subclass.
 * Use the [AdminPannelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdminPannelFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_pannel, container, false)
    }


}