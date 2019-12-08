package com.adikres.eleskaapp.rekap_tenagateknik

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adikres.eleskaapp.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.fragment_tenaga_teknik.view.*


class TenagaTeknikFragment : Fragment() {

    private lateinit var chart1: PieChart
    private lateinit var chart2: PieChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tenaga_teknik, container, false)
        chart1 = view.tenagateknik_kompeten_belum_chart
        chart2 = view.tenagateknik_kompeten_belum_jkk_chart
        return view
    }

    override fun onStart() {
        super.onStart()
        inflateChart1()
        inflateChart2()
    }

    fun inflateChart1() {
        chart1.setUsePercentValues(true)
        chart1.description.isEnabled = false
        chart1.setExtraOffsets(5f, 10f, 5f, 5f)

        chart1.dragDecelerationFrictionCoef = 0.95f


        chart1.isDrawHoleEnabled = true
        chart1.setHoleColor(Color.WHITE)

        chart1.setTransparentCircleColor(Color.WHITE)
        chart1.setTransparentCircleAlpha(110)

        chart1.holeRadius = 58f
        chart1.transparentCircleRadius = 61f

        chart1.setDrawCenterText(true)

        chart1.rotationAngle = 0f
        // enable rotation of the chart by touch
        // enable rotation of the chart by touch
        chart1.isRotationEnabled = true
        chart1.isHighlightPerTapEnabled = true

        // chart.setUnit(" €");
        // chart.setDrawUnitsInChart(true);

        // add a selection listener
        // chart.setUnit(" €");
// chart.setDrawUnitsInChart(true);
// add a selection listener

        chart1.animateY(1400, Easing.EaseInOutQuad)
        // chart.spin(2000, 0, 360);

        // chart.spin(2000, 0, 360);
        val l = chart1.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(false)
        l.xEntrySpace = 7f
        l.yEntrySpace = 0f
        l.yOffset = 0f
        l.isEnabled = true

        // entry label styling
        // entry label styling
        chart1.setEntryLabelColor(Color.WHITE)
        chart1.setEntryLabelTextSize(12f)
        setDataFOrChart1()
    }

    fun setDataFOrChart1() {
        val entries: ArrayList<PieEntry> = ArrayList()

        val pie1 = PieEntry(1f, "Belum Kompeten")
        entries.add(
            pie1
        )

        val pie2 = PieEntry(1f, "Kompeten")
        entries.add(
            pie2
        )

        val dataSet = PieDataSet(entries, "Perbandingan Jumlah Tenaga Teknik")

        dataSet.setDrawIcons(false)

        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        dataSet.colors = arrayListOf(Color.rgb(241, 196, 15), Color.rgb(211, 84, 0))
        //dataSet.setSelectionShift(0f);

        //dataSet.setSelectionShift(0f);
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter(chart1))
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
        chart1.data = data

        chart1.highlightValues(null)
        chart1.invalidate()
    }

    fun inflateChart2() {
        chart2.setUsePercentValues(true)
        chart2.description.isEnabled = false
        chart2.setExtraOffsets(5f, 10f, 5f, 5f)

        chart2.dragDecelerationFrictionCoef = 0.95f


        chart2.isDrawHoleEnabled = true
        chart2.setHoleColor(Color.WHITE)

        chart2.setTransparentCircleColor(Color.WHITE)
        chart2.setTransparentCircleAlpha(110)

        chart2.holeRadius = 58f
        chart2.transparentCircleRadius = 61f

        chart2.setDrawCenterText(true)

        chart2.rotationAngle = 0f
        // enable rotation of the chart by touch
        // enable rotation of the chart by touch
        chart2.isRotationEnabled = true
        chart2.isHighlightPerTapEnabled = true

        // chart.setUnit(" €");
        // chart.setDrawUnitsInChart(true);

        // add a selection listener
        // chart.setUnit(" €");
// chart.setDrawUnitsInChart(true);
// add a selection listener

        chart2.animateY(1400, Easing.EaseInOutQuad)
        // chart.spin(2000, 0, 360);

        // chart.spin(2000, 0, 360);
        val l = chart2.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false)
        l.xEntrySpace = 7f
        l.yEntrySpace = 0f
        l.yOffset = 0f
        l.isEnabled = true

        // entry label styling
        // entry label styling
        chart2.setEntryLabelColor(Color.WHITE)
        chart2.setEntryLabelTextSize(12f)
        setDataFOrChart2()
    }

    fun setDataFOrChart2() {
        val entries: ArrayList<PieEntry> = ArrayList()

        val pie1 = PieEntry(1f, "Level 1")
        entries.add(
            pie1
        )

        val pie2 = PieEntry(1f, "Level 2")
        entries.add(
            pie2
        )

        val pie3 = PieEntry(1f, "Level 3")
        entries.add(
            pie3
        )

        val pie4 = PieEntry(1f, "Level 4")
        entries.add(
            pie4
        )

        val pie5 = PieEntry(1f, "Level 5")
        entries.add(
            pie5
        )

        val pie6 = PieEntry(1f, "Level 6")
        entries.add(
            pie6
        )

        val dataSet = PieDataSet(entries, "")

        dataSet.setDrawIcons(false)

        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        dataSet.colors = arrayListOf(
            Color.rgb(241, 196, 15),
            Color.rgb(211, 84, 0),
            Color.parseColor("#E64823"),
            Color.parseColor("#FAB462"),
            Color.parseColor("#EC7016"),
            Color.parseColor("#9C6A6A")
            )
        //dataSet.setSelectionShift(0f);

        //dataSet.setSelectionShift(0f);
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter(chart1))
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
        chart2.data = data

        chart2.highlightValues(null)
        chart2.invalidate()
    }


}
