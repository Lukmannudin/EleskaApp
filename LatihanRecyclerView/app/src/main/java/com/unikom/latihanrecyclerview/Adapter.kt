package com.unikom.latihanrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val dataset: ArrayList<Model>) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        Log.d("cekcek", "${dataset[position].nama}")

        holder.nama.text = dataset[position].nama
        holder.subject.text = dataset[position].subject
        holder.text.text = dataset[position].text
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama: TextView = itemView.findViewById(R.id.tvNama)
        val subject: TextView = itemView.findViewById(R.id.tvSubject)
        val text: TextView = itemView.findViewById(R.id.tvText)
    }
}