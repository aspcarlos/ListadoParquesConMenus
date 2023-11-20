package com.example.listadoparques.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listadoparques.Parques
import com.example.listadoparques.R

class ParquesAdapter(private var parquesList: List<Parques>) : RecyclerView.Adapter<ParquesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParquesViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_parques, parent, false)
        return ParquesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return parquesList.size
    }

    override fun onBindViewHolder(holder: ParquesViewHolder, position: Int) {
        val item = parquesList[position]
        holder.render(item)
    }

    fun actualizarParques(listaparque: List<Parques>) {
        this.parquesList = listaparque
        notifyDataSetChanged()
    }
}