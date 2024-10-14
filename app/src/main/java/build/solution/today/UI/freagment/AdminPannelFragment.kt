package build.solution.today.UI.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import build.solution.retrofit.R
import build.solution.today.UI.TabConceptActivity

/**
 * A simple [Fragment] subclass.
 * Use the [AdminPannelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdminPannelFragment : Fragment() {

    private lateinit var centerClassText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_pannel, container, false)

        centerClassText = view.findViewById(R.id.CenterClassTExt)
        centerClassText.setOnClickListener {
            Toast.makeText(requireContext(), "Going Now", Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireActivity(), TabConceptActivity::class.java))
        }

        return view
    }
}
