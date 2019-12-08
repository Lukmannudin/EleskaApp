package com.adikres.eleskaapp.rekap_ujikompetensi


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adikres.eleskaapp.R
import com.adikres.eleskaapp.utilities.MyMarkerView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import kotlinx.android.synthetic.main.fragment_uji_kompetensi.view.*

/**
 * A simple [Fragment] subclass.
 */
class UjiKompetensiFragment : Fragment() {

    private lateinit var mChart: BarChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_uji_kompetensi, container, false)
        mChart = view.uji_kompetensi_chart
        return view
    }

    override fun onStart() {
        super.onStart()
        setChart()
    }


    fun setChart() {
        mChart.setDrawBarShadow(false)
        mChart.description.isEnabled = false
        mChart.setPinchZoom(false)
        mChart.setDrawGridBackground(false)
        // empty labels so that the names are spread evenly
        // empty labels so that the names are spread evenly
        val labels =
            arrayOf(
                "",
                "Jan",
                "Feb",
                "Mar",
                "April",
                "Mei",
                "Jun",
                "Jul",
                "Agus",
                "Sept",
                "Okt",
                "Nop",
                "Des",
                ""
            )
        val xAxis: XAxis = mChart.xAxis

        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.granularity = 0.5f // only intervals of 1 day

        xAxis.textColor = Color.BLACK
        xAxis.textSize = 12f
        xAxis.axisLineColor = Color.WHITE
        xAxis.axisMinimum = 0f
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)

        val leftAxis: YAxis = mChart.axisLeft
        leftAxis.textColor = Color.BLACK
        leftAxis.textSize = 12f
        leftAxis.axisLineColor = Color.WHITE
        leftAxis.setDrawGridLines(true)
        leftAxis.setLabelCount(8, true)
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        leftAxis.axisMinimum = 0f

        mChart.axisRight.isEnabled = false
        mChart.legend.isEnabled = true

        setLegend(mChart.legend)
        val valOne = floatArrayOf(
            286f,
            355f,
            315f,
            270f,
            217f,
            369f,
            90f,
            292f,
            544f,
            571f,
            598f,
            317f
        )
        val barOne: ArrayList<BarEntry> = ArrayList()
        val barTwo: ArrayList<BarEntry> = ArrayList()
        for (i in valOne.indices) {
            barOne.add(BarEntry(i.toFloat()+1 , valOne[i]))
        }


        val mv = MyMarkerView(requireContext(), R.layout.custom_marker_view)
        mv.chartView = mChart // For bounds control
        mChart.marker = mv

        val set1 = BarDataSet(barOne, "Sertifikat")
        set1.color = Color.rgb(241, 196, 15)

        val set2 = BarDataSet(barTwo, "Tenaga Teknik")
        set2.color = Color.rgb(211, 84, 0)

        set1.isHighlightEnabled = true
        set2.isHighlightEnabled = true
        set1.setDrawValues(true)
        set2.setDrawValues(true)

        val dataSets = ArrayList<IBarDataSet>()
        dataSets.add(set1)
        dataSets.add(set2)


        val data = BarData(set1)

        val groupSpace = 0.4f
        val barSpace = 0f
        val barWidth = 0.9f
        // (barSpace + barWidth) * 2 + groupSpace = 1
        // (barSpace + barWidth) * 2 + groupSpace = 1
        data.barWidth = barWidth
        // so that the entire chart is shown when scrolled from right to left
        // so that the entire chart is shown when scrolled from right to left
        xAxis.axisMaximum = labels.size - 1.1f
        xAxis.labelCount = 12

        mChart.data = data
        mChart.setScaleEnabled(false)
        mChart.animateY(1000)
        mChart.extraBottomOffset = 4f
        mChart.invalidate()
    }

    fun setLegend(l: Legend) {
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(true)
        l.setDrawInside(true)
        l.yOffset = 0f
        l.xOffset = 10f
        l.yEntrySpace = 0f
        l.textSize = 8f
    }


}
