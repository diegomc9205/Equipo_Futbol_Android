package com.example.equipofutbol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.equipofutbol.databinding.FragmentGaleriaBinding
import com.example.equipofutbol.databinding.FragmentGaleriaGrandeBinding


class FragmentGaleriaGrande : Fragment() {

    private lateinit var binding: FragmentGaleriaGrandeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGaleriaGrandeBinding.inflate(inflater, container, false)
        return (binding.root)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            binding.imagencentralgrande.setImageResource(bundle.getInt("imagen"))
        }


    }
}