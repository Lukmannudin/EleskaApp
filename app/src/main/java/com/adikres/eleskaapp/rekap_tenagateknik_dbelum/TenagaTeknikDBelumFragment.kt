package com.adikres.eleskaapp.rekap_tenagateknik_dbelum


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.adikres.eleskaapp.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import kotlinx.android.synthetic.main.fragment_tenaga_teknik_dbelum.view.*

/**
 * A simple [Fragment] subclass.
 */
class TenagaTeknikDBelumFragment : Fragment() {
    private lateinit var barChart: BarChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_tenaga_teknik_dbelum, container, false)
        barChart = view.tenagateknik_dbelum_chart
        return view
    }

    override fun onStart() {
        super.onStart()
        inflateChart()
    }

    fun inflateChart() {

        barChart.setDrawBarShadow(false)
        barChart.description.isEnabled = false
        barChart.setPinchZoom(false)
        barChart.setDrawGridBackground(false)
        val barEntries: ArrayList<BarEntry> = ArrayList()
        val barEntries1: ArrayList<BarEntry> = ArrayList()
        val barEntries2: ArrayList<BarEntry> = ArrayList()
        val barEntries3: ArrayList<BarEntry> = ArrayList()

        val valOne = floatArrayOf(
            32f,
            268f,
            1028f,
            1116f,
            2101f,
            1035f,
            495f,
            759f,
            1355f,
            1347f,
            585f,
            1000f
        )

        val valTwo = floatArrayOf(
            21f,
            102f,
            199f,
            220f,
            878f,
            324f,
            241f,
            357f,
            201f,
            325f,
            201f,
            192f
        )

        val valThree = floatArrayOf(
            181f,
            738f,
            3478f,
            2401f,
            3909f,
            1889f,
            1763f,
            1510f,
            1715f,
            2171f,
            948f,
            1487f
        )

        val valFour = floatArrayOf(
            0f,
            49f,
            1637f,
            826f,
            1065f,
            566f,
            407f,
            497f,
            298f,
            314f,
            12f,
            215f
        )

        for (i in valOne.indices) {
            barEntries.add(BarEntry(i.toFloat() + 2, valOne[i]))
            barEntries1.add(BarEntry(i.toFloat() + 2, valTwo[i]))
            barEntries2.add(BarEntry(i.toFloat() + 2, valThree[i]))
            barEntries3.add(BarEntry(i.toFloat() + 2, valFour[i]))
        }

        val labels =
            arrayOf(
                "Jan","",
                "Feb","",
                "Mar","",
                "April","",
                "Mei","",
                "Jun","",
                "Jul","",
                "Agust","",
                "Sept","",
                "Okt","",
                "Nop","",
                "Des","",""
            )


        val barDataSet = BarDataSet(barEntries, "Pembangkit")
        barDataSet.color = Color.parseColor("#FFCA08")
        val barDataSet1 = BarDataSet(barEntries1, "Transmisi")
        barDataSet1.setColors(Color.parseColor("#CE8D3E"))
        val barDataSet2 = BarDataSet(barEntries2, "Distribusi")
        barDataSet2.setColors(Color.parseColor("#E64823"))
        val barDataSet3 = BarDataSet(barEntries3, "IPTL")
        barDataSet3.setColors(Color.parseColor("#FAB462"))


        val data =
            BarData(barDataSet, barDataSet1, barDataSet2, barDataSet3)
        barChart.data = data

        val xAxis: XAxis = barChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)
        barChart.axisLeft.axisMinimum = 1f
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 2f
        xAxis.setCenterAxisLabels(true)
        xAxis.isGranularityEnabled = true
        barChart.axisRight.isEnabled = false
        setLegend(barChart.legend!!)


        val barSpace = 0.00f
        val groupSpace = 0.2f
        val groupCount = 6

        data.barWidth = 0.45f
        barChart.xAxis.axisMinimum = 0f
        xAxis.axisMaximum = labels.size - 1.1f

        barChart.groupBars(0f, groupSpace, barSpace)
        barChart.setVisibleXRangeMaximum(8f)
        barChart.animateY(1000)

        barChart.invalidate()

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
