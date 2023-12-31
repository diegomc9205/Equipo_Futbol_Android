package com.example.equipofutbol

import Jugador
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.equipofutbol.databinding.HolderList2Binding


class JugadorAdapter : RecyclerView.Adapter<JugadorAdapter.VistaCelda>() {
    var miLista = ArrayList<Jugador>()

    inner class VistaCelda(val binding: HolderList2Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCelda { //crea la celda
        val inflater = LayoutInflater.from(parent.context)
        val binding = HolderList2Binding.inflate(inflater, parent, false)
        val celda = VistaCelda(binding)
        return celda
    }


    override fun getItemCount(): Int { //nos devuelve el tamaño del array y sirve para ver cuantos elementos mostrar
        return miLista.size
    }

    override fun onBindViewHolder(
        holder: VistaCelda,
        position: Int
    ) { //coloca la informacion en la celda
        val jugador = miLista[position]
        Glide.with(holder.itemView).load(jugador.img).placeholder(R.drawable.player)
            .into(holder.binding.ImagenJugadres)
        holder.binding.nombreJugador.text = jugador.nombre
        holder.binding.posicionJugador.text = jugador.Posicion

        val context = holder.itemView.context
        val red = ContextCompat.getColor(context, R.color.red)
        val green = ContextCompat.getColor(context, R.color.green)
        val blue = ContextCompat.getColor(context, R.color.blue)
        val purple = ContextCompat.getColor(context, R.color.purple_200)
        val black = ContextCompat.getColor(context, R.color.black)

        if (jugador.id == 1) {
            holder.binding.nombreJugador.setBackgroundColor(purple)
            holder.binding.posicionJugador.setBackgroundColor(purple)
        } else if (jugador.id > 1 && jugador.id <= 5) {
            holder.binding.nombreJugador.setBackgroundColor(blue)
            holder.binding.posicionJugador.setBackgroundColor(blue)
        } else if (jugador.id > 5 && jugador.id <= 9) {
            holder.binding.nombreJugador.setBackgroundColor(green)
            holder.binding.posicionJugador.setBackgroundColor(green)
        } else if (jugador.id > 9 && jugador.id <= 11) {
            holder.binding.nombreJugador.setBackgroundColor(red)
            holder.binding.posicionJugador.setBackgroundColor(red)
        } else {
            holder.binding.nombreJugador.setBackgroundColor(black)
            holder.binding.posicionJugador.setBackgroundColor(black)
        }


        holder.itemView.setOnClickListener {
            val bundle = bundleOf(
                "jugador" to miLista[position]
            )
            Navigation.findNavController(it)
                .navigate(R.id.action_fragmentEquipo_to_fragmentInfoJugador, bundle)

        }
    }

    fun llenarLista(lista: List<Jugador>) {
        miLista.addAll(lista)
        notifyDataSetChanged()
    }
}