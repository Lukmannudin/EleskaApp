package com.adikres.eleskaapp.rekap_ujikompetensi


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.adikres.eleskaapp.R

/**
 * A simple [Fragment] subclass.
 */
class UjiKompetensiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_uji_kompetensi, container, false)
    }


}
