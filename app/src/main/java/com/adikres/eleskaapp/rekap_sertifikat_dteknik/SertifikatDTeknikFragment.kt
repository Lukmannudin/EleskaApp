package com.adikres.eleskaapp.rekap_sertifikat_dteknik

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.adikres.eleskaapp.R
import com.adikres.eleskaapp.utilities.MyMarkerView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.fragment_sertifikat_dteknik.view.*
import java.text.DecimalFormat


class SertifikatDTeknikFragment : Fragment() {

    private lateinit var mChart: BarChart
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sertifikat_dteknik, container, false)
        mChart = view.sertifikat_dteknik_chart
        return view
    }

    override fun onStart() {
        super.onStart()
        setChart()
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
                "Agust",
                "Sept",
                "Okt",
                "Nop",
                "Des",
                ""
            )
        val xAxis: XAxis = mChart.xAxis

        xAxis.setCenterAxisLabels(true)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(true)
        xAxis.granularity = 1f // only intervals of 1 day

        xAxis.textColor = Color.BLACK
        xAxis.textSize = 12f
        xAxis.axisLineColor = Color.WHITE
        xAxis.axisMinimum = 1f
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)

        val leftAxis: YAxis = mChart.axisLeft
        leftAxis.textColor = Color.BLACK
        leftAxis.textSize = 12f
        leftAxis.axisLineColor = Color.WHITE
        leftAxis.setDrawGridLines(true)
        leftAxis.granularity = 2f
        leftAxis.setLabelCount(8, true)
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        leftAxis.axisMinimum = 0f

        mChart.axisRight.isEnabled = false
        mChart.legend.isEnabled = true

        setLegend(view?.sertifikat_dteknik_chart?.legend!!)
        val valOne = floatArrayOf(
            387f,
            1478f,
            8641f,
            6710f,
            11547f,
            6372f,
            4248f,
            4176f,
            4471f,
            5481f,
            2079f,
            3521f
        )
        val valTwo = floatArrayOf(
            234f,
            1138f,
            4909f,
            4018f,
            7187f,
            3633f,
            2843f,
            3051f,
            3598f,
            4471f,
            1741f,
            2857f
        )

        val barOne: ArrayList<BarEntry> = ArrayList()
        val barTwo: ArrayList<BarEntry> = ArrayList()
        for (i in valOne.indices) {
            barOne.add(BarEntry(i.toFloat() + 1, valOne[i]))
            barTwo.add(BarEntry(i.toFloat() + 1, valTwo[i]))
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
        val data = BarData(dataSets)
        val groupSpace = 0.4f
        val barSpace = 0f
        val barWidth = 0.3f
        // (barSpace + barWidth) * 2 + groupSpace = 1
        // (barSpace + barWidth) * 2 + groupSpace = 1
        data.barWidth = barWidth
        // so that the entire chart is shown when scrolled from right to left
        // so that the entire chart is shown when scrolled from right to left
        xAxis.axisMaximum = labels.size - 1.1f

        mChart.data = data
        mChart.setScaleEnabled(true)
        mChart.setVisibleXRangeMaximum(8f)
        mChart.groupBars(1f, groupSpace, barSpace)
        mChart.animateY(1000)
        mChart.extraBottomOffset = 4f
        mChart.invalidate()
    }

    @SuppressLint("ViewConstructor")
    class XYMarkerView(context: Context, private val xAxisValueFormatter: ValueFormatter) :
        MarkerView(context, R.layout.barchart_marker_pointer) {

        private val tvContent: TextView = findViewById(R.id.tvContent)

        private val format: DecimalFormat = DecimalFormat("###.0")

        override fun refreshContent(e: Entry, highlight: Highlight?) {

            tvContent.text =
                String.format(
                    "%s\n%s",
                    xAxisValueFormatter.getFormattedValue(e.x),
                    format.format(e.y.toDouble())
                )

            super.refreshContent(e, highlight)
        }

        override fun getOffset(): MPPointF {
            return MPPointF((-(width / 2)).toFloat(), (-height).toFloat())
        }
    }
}
