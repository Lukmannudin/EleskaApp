package com.adikres.eleskaapp.rekap_tenagateknik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adikres.eleskaapp.R
import com.github.mikephil.charting.charts.BarChart

class TenagaTeknikFragment : Fragment() {

    private lateinit var mChart: BarChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_tenaga_teknik, container, false)

        return view
    }

}
