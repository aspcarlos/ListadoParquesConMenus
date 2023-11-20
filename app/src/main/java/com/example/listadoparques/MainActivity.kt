package com.example.listadoparques

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadoparques.adapter.ParquesAdapter
import com.example.listadoparques.databinding.ActivityMainBinding

open class MainActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("ListadoParques")
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Configura la vista de la actividad con binding.root

        val manager = LinearLayoutManager(this)


        binding.recycler.layoutManager = LinearLayoutManager(this)
        var adapter=ParquesAdapter(ParquesProvider.parquesList)
        binding.recycler.adapter = adapter


        binding.filtro.addTextChangedListener {filtro ->
            val filtroParque = ParquesProvider.parquesList.filter { parque ->
                parque.nombre.contains(filtro.toString())  }
        }

        binding.filtro.addTextChangedListener { filtro ->
            val filtroParque = ParquesProvider.parquesList.filter { parque ->
                parque.nombre.lowercase().contains(filtro.toString().lowercase()) }
                adapter.actualizarParques(filtroParque)
            }
        }
    }


