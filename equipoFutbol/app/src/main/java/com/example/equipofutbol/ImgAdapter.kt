package com.example.equipofutbol

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.equipofutbol.databinding.HolderListBinding

class ImgAdapter : Adapter<ImgAdapter.VistaCelda>() {
    var miLista = ArrayList<Int>()

    inner class VistaCelda(val binding: HolderListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCelda { //crea la celda
        val inflater = LayoutInflater.from(parent.context)
        val binding = HolderListBinding.inflate(inflater, parent, false)
        val celda = VistaCelda(binding)
        return celda
    }


    override fun getItemCount(): Int {        //nos devuelve el tamaño del array y sirve para ver cuantos elementos mostrar
        return miLista.size
    }

    override fun onBindViewHolder(
        holder: VistaCelda,
        position: Int
    ) { //coloca la informacion en la celda
        val texto = miLista[position]
        holder.binding.ImagenJugadres.setImageResource(texto)

        holder.itemView.setOnClickListener { }

        holder.binding.ImagenJugadres.setOnClickListener {
            val bundle = bundleOf("imagen" to texto)
            Navigation.findNavController(holder.itemView)
                .navigate(R.id.action_fragmentGaleria_to_fragmentGaleriaGrande, bundle)
        }


    }

    fun llenarLista(lista: List<Int>) {
        miLista.addAll(lista)
        notifyDataSetChanged()
    }
}