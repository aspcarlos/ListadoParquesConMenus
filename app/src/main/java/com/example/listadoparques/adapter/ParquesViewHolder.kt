package com.example.listadoparques.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listadoparques.Parques
import com.example.listadoparques.databinding.ItemParquesBinding

class ParquesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemParquesBinding.bind(view)

    fun render(parquesModel: Parques) {
        binding.NombreParque1.text = parquesModel.nombre
        binding.DescripcionParque2.text = parquesModel.descripcion

        // Suponiendo que `parquesModel.photo` sea una URL o recurso de imagen válido
        Glide.with(binding.imageParque1.context).load(parquesModel.photo).into(binding.imageParque1)

        binding.imageParque1.setOnClickListener{ Toast.makeText(binding.imageParque1.context, parquesModel.nombre, Toast.LENGTH_SHORT).show()}
        itemView.setOnClickListener{ Toast.makeText(binding.imageParque1.context, parquesModel.nombre, Toast.LENGTH_SHORT).show()}

        /*
        // Evento de hacer clic sobre la imagen de un parque
        binding.imageParque1.setOnClickListener {
            Toast.makeText(itemView.context, parquesModel.nombre, Toast.LENGTH_LONG).show()
        }

        // Evento de hacer clic sobre el parque
        itemView.setOnClickListener {
            Toast.makeText(itemView.context, parquesModel.descripcion, Toast.LENGTH_LONG).show()
        }
        */

    }
}