package com.adikres.eleskaapp.rekap_agendauji


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adikres.eleskaapp.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import kotlinx.android.synthetic.main.fragment_agenda_uji.view.*

/**
 * A simple [Fragment] subclass.
 */
class AgendaUjiFragment : Fragment() {

    private lateinit var mpBarChart: BarChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_agenda_uji, container, false)
        mpBarChart = view.agenda_uji_barchart
        return view
    }

    override fun onStart() {
        super.onStart()
        val barDataSet1 = BarDataSet(barEntries(),"Dataset1")
        barDataSet1.color = Color.RED
        val barDataSet2 = BarDataSet(barEntries2(),"Dataset2")
        barDataSet2.color = Color.BLUE
        val barDataSet3 = BarDataSet(barEntries3(),"Dataset3")
        barDataSet3.color = Color.MAGENTA
        val barDataSet4 = BarDataSet(barEntries(),"Dataset4")
        barDataSet4.color = Color.GREEN

        val data = BarData(barDataSet1,barDataSet2, barDataSet3, barDataSet3, barDataSet4)
        mpBarChart.data = data

        val days = arrayOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
        val xAxis= mpBarChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(days)
        xAxis.setCenterAxisLabels(true)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.isGranularityEnabled = true

        mpBarChart.isDragEnabled = true
        mpBarChart.setVisibleXRangeMaximum(3f)

        val barSpace = 0.08f
        val groupSpace = 0.1f
        data.barWidth = 0.10f

        mpBarChart.xAxis.axisMinimum = 0f
        mpBarChart.xAxis.axisMaximum = 0 + mpBarChart.barData.getGroupWidth(groupSpace,barSpace) * 7
        mpBarChart.axisLeft.axisMinimum = 0f

        mpBarChart.groupBars(0f, groupSpace, barSpace)
        mpBarChart.invalidate()
    }
    fun inflateChart() {

    }

    fun barEntries(): ArrayList<BarEntry> {
        val barEntries: ArrayList<BarEntry> = ArrayList()
        barEntries.add(BarEntry(1f, 2000f))
        barEntries.add(BarEntry(2f, 791f))
        barEntries.add(BarEntry(3f, 630f))
        barEntries.add(BarEntry(4f, 458f))
        barEntries.add(BarEntry(5f, 2724f))
        barEntries.add(BarEntry(6f, 2173f))
        return barEntries
    }

    fun barEntries2(): ArrayList<BarEntry> {
        val barEntries: ArrayList<BarEntry> = ArrayList()
        barEntries.add(BarEntry(1f, 100f))
        barEntries.add(BarEntry(2f, 291f))
        barEntries.add(BarEntry(3f, 1230f))
        barEntries.add(BarEntry(4f, 1168f))
        barEntries.add(BarEntry(5f, 114f))
        barEntries.add(BarEntry(6f, 173f))
        return barEntries
    }

    fun barEntries3(): ArrayList<BarEntry> {
        val barEntries: ArrayList<BarEntry> = ArrayList()
        barEntries.add(BarEntry(1f, 200f))
        barEntries.add(BarEntry(2f, 131f))
        barEntries.add(BarEntry(3f, 143f))
        barEntries.add(BarEntry(4f, 1234f))
        barEntries.add(BarEntry(5f, 1234f))
        barEntries.add(BarEntry(6f, 21f))
        return barEntries
    }
}
