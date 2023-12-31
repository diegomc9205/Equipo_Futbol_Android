package com.example.equipofutbol

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.equipofutbol.databinding.FragmentGaleriaBinding
import com.example.equipofutbol.databinding.LoginBinding


class FragmentGaleria : Fragment() {

    private lateinit var binding: FragmentGaleriaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGaleriaBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listado = ArrayList<Int>()
        listado.add(R.drawable.galeria_10)
        listado.add(R.drawable.galeria_11)
        listado.add(R.drawable.galeria_12)
        listado.add(R.drawable.galeria_13)
        listado.add(R.drawable.galeria_14)
        listado.add(R.drawable.galeria_15)
        listado.add(R.drawable.galeria_16)
        listado.add(R.drawable.galeria_17)
        listado.add(R.drawable.galeria_18)
        listado.add(R.drawable.galeria_19)
        listado.add(R.drawable.galeria_2)
        listado.add(R.drawable.galeria_3)
        listado.add(R.drawable.galeria_4)
        listado.add(R.drawable.galeria_5)
        listado.add(R.drawable.galeria_6)
        listado.add(R.drawable.galeria_7)
        listado.add(R.drawable.galeria_8)
        listado.add(R.drawable.galeria_9)


        val adapter = ImgAdapter()
        binding.galeriaImg.adapter = adapter
        adapter.llenarLista(listado)

        val layoutManager = StaggeredGridLayoutManager(3, RecyclerView.HORIZONTAL)
        binding.galeriaImg.layoutManager = layoutManager


    }

}
