package com.adikres.eleskaapp.rekap_agendauji


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adikres.eleskaapp.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Legend
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

    private lateinit var barChart: BarChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_agenda_uji, container, false)
        barChart = view.agenda_uji_barchart
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
        val barEntries4: ArrayList<BarEntry> = ArrayList()
        val barEntries5: ArrayList<BarEntry> = ArrayList()

        val valOne = floatArrayOf(
            2304f,
            2226f,
            2102f,
            1156f,
            984f,
            393f,
            1078f,
            52f,
            1037f,
            3123f,
            3058f,
            6281f
        )

        val valTwo = floatArrayOf(
            197f,
            20f,
            0f,
            0f,
            0f,
            0f,
            335f,
            408f,
            5295f,
            3567f,
            965f,
            1252f
        )

        val valThree = floatArrayOf(
            24f,
            17f,
            0f,
            0f,
            0f,
            3f,
            0f,
            32f,
            160f,
            40f,
            46f,
            41f
        )

        val valFour = floatArrayOf(
            1832f,
            2054f,
            176f,
            414f,
            195f,
            3f,
            0f,
            13f,
            64f,
            55f,
            4270f,
            2803f
        )

        val valFive = floatArrayOf(
            2f,
            0f,
            176f,
            36f,
            36f,
            0f,
            0f,
            0f,
            0f,
            0f,
            15f,
            0f
        )

        val valSix = floatArrayOf(
            0f,
            0f,
            0f,
            1f,
            0f,
            0f,
            0f,
            0f,
            0f,
            0f,
            0f,
            18f
        )

        for (i in valOne.indices) {
            barEntries.add(BarEntry(i.toFloat() + 2, valOne[i]))
            barEntries1.add(BarEntry(i.toFloat() + 2, valTwo[i]))
            barEntries2.add(BarEntry(i.toFloat() + 2, valThree[i]))
            barEntries3.add(BarEntry(i.toFloat() + 2, valFour[i]))
            barEntries4.add(BarEntry(i.toFloat() + 2, valFive[i]))
            barEntries5.add(BarEntry(i.toFloat() + 2, valSix[i]))
        }
        val labels =
            arrayOf(
                "Jan",
                "",
                "",
                "",
                "Feb",
                "",
                "",
                "",
                "Mar",
                "",
                "",
                "",
                "April",
                "",
                "",
                "",
                "Mei",
                "",
                "",
                "",
                "Jun",
                "",
                "",
                "",
                "Jul",
                "",
                "",
                "",
                "Agust",
                "",
                "",
                "",
                "Sept",
                "",
                "",
                "",
                "Okt",
                "",
                "",
                "",
                "Nop",
                "",
                "",
                "",
                "Des",
                "",
                "",
                "",
                ""
            )


        val barDataSet = BarDataSet(barEntries, "Uji Kompetensi")
        barDataSet.color = Color.parseColor("#FFCA08")
        val barDataSet1 = BarDataSet(barEntries1, "Penyetaraan")
        barDataSet1.setColors(Color.parseColor("#CE8D3E"))
        val barDataSet2 = BarDataSet(barEntries2, "Vokasional")
        barDataSet2.setColors(Color.parseColor("#E64823"))
        val barDataSet3 = BarDataSet(barEntries3, "Perpanjangan")
        barDataSet3.setColors(Color.parseColor("#FAB462"))
        val barDataSet4 = BarDataSet(barEntries4, "Penyesuaian")
        barDataSet4.setColors(Color.parseColor("#EC7016"))
        val barDataSet5 = BarDataSet(barEntries5, "Sertifikasi Ulang")
        barDataSet5.setColors(Color.parseColor("#9C6A6A"))


        val data =
            BarData(barDataSet, barDataSet1, barDataSet2, barDataSet3, barDataSet4, barDataSet5)
        barChart.data = data

        val xAxis: XAxis = barChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)
        barChart.axisLeft.axisMinimum = 0f
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 4f
        xAxis.setCenterAxisLabels(true)
        xAxis.isGranularityEnabled = true
        barChart.axisRight.isEnabled = false
        setLegend(barChart.legend!!)


        val barSpace = 0.00f
        val groupSpace = 0.2f
        val groupCount = 6

        data.barWidth = 0.633f
        barChart.xAxis.axisMinimum = 0f
        xAxis.axisMaximum = labels.size - 1.1f

        barChart.groupBars(0f, groupSpace, barSpace)
        barChart.setVisibleXRangeMaximum(12f)
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
