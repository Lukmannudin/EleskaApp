package com.unikom.latihanrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataset = ArrayList<Model>()
        dataset.add(Model("Jajang","Beli makanan","uyy"))
        dataset.add(Model("Ucup","Main","yuk main"))
        dataset.add(Model("Asep","PR","udah belum?"))

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(dataset)

        val dividerItemDecoration = DividerItemDecoration(
            this,
            RecyclerView.VERTICAL
        )
        recyclerView.addItemDecoration(dividerItemDecoration)

        recyclerView.adapter = adapter
    }


}
