package motion.kelas.libraryexample.mpchart

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_mpchart.view.*
import motion.kelas.libraryexample.R


/**
 * A simple [Fragment] subclass.
 */
class MPChartFragment : Fragment() {
    // TODO : ADD Global Variable Here

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mpchart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBarchart(view)
    }

    private fun initBarchart(view: View) {
        // TODO : CReate BarChart Data Here !!!

        // TODO : Create Dataset For BarData Here !!!

        // TODO : Create BarData For MPCHART HERE !!!

        // TODO : CONFIG MPCHART HERE !!!

        // TODO : Connecting data to mpchart here !!!
    }
}
