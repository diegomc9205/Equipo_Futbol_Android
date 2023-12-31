package com.example.equipofutbol

import Jugador
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.equipofutbol.databinding.FragmentInfoJugadorBinding

class FragmentInfoJugador : Fragment() {

    private lateinit var binding: FragmentInfoJugadorBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoJugadorBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            val jugador = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable("jugador", Jugador::class.java)
            } else {
                bundle.getParcelable("jugador")
            }
            if (jugador != null) {
                Glide.with(requireContext()).load(jugador.img).placeholder(R.drawable.player)
                    .into(binding.imgcard)

                binding.nombre.text = jugador.apodo
                binding.puesto.text = jugador.pos
                binding.edad.text = jugador.fecha
                binding.nacimiento.text = jugador.lugar
                binding.altura.text = jugador.altura
                binding.peso.text = jugador.peso
                binding.procedencia.text = jugador.procedencia
                binding.masinfo.text = jugador.info
                binding.tvcardnombre.text = jugador.nombre
                binding.tvcardnum.text = jugador.id.toString()


            }
        }


    }


}

