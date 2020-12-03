package motion.kelas.libraryexample.mpchart

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.android.synthetic.main.fragment_mpchart.view.*
import motion.kelas.libraryexample.R


/**
 * A simple [Fragment] subclass.
 */
class MPChartFragment : Fragment() {
    val entries = arrayListOf<BarEntry>()
    val listOfMonth = arrayListOf<String>("Jan","Feb","Mar","Apr","Mei","Jun","Jul","Aug","Oct","Nov","Des")

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
        loadData(view)
    }

    private fun loadData(view: View) {
        view.bcMPChart.notifyDataSetChanged()
    }

    private fun initBarchart(view: View) {
        entries.add(BarEntry(1f, 10f))
        entries.add(BarEntry(2f, 20f))
        entries.add(BarEntry(3f, 10f))
        entries.add(BarEntry(4f, 30f))
        entries.add(BarEntry(5f, 80f))
        entries.add(BarEntry(6f, 10f))

        val dataset = BarDataSet(entries,"Person In Month")
        dataset.color = Color.parseColor("#FF5722")
        dataset.valueTextColor = Color.parseColor("#888888")

        val data = BarData(dataset)
        data.barWidth = 0.9f

        view.bcMPChart.data = data
        view.bcMPChart.animateY(5000)
        view.bcMPChart.setFitBars(true)
        view.bcMPChart.description.isEnabled = true
        view.bcMPChart.xAxis.valueFormatter = IndexAxisValueFormatter(listOfMonth)
        view.bcMPChart.xAxis.granularity = 1f
        view.bcMPChart.xAxis.isGranularityEnabled = true
        view.bcMPChart.invalidate()
    }
}
