package com.example.equipofutbol

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.equipofutbol.databinding.FragmentBienvenidoBinding


class FragmentBienvenido : Fragment() {

    private lateinit var binding: FragmentBienvenidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBienvenidoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var clickCount = 0
        val prefs = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)




        binding.imageView2.setOnClickListener {
//            prefs.getBoolean("hasWon",true)   no entiendo porque no funciona
            clickCount++
            if (clickCount == 10) {
                val editor = activity?.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)?.edit()
                editor?.putBoolean("hasWon", true)
                if (editor != null) {
                    editor.apply()
                }

                val alertDialogBuilder = AlertDialog.Builder(this.requireContext())
                alertDialogBuilder.setTitle("¡Felicitaciones!")
                alertDialogBuilder.setMessage("Has ganado un premio.")
                alertDialogBuilder.setPositiveButton("OK", null)
                alertDialogBuilder.create().show()

                binding.imageView2.setOnClickListener(null)
            }
        }

//        if (prefs.getBoolean("hasWon", false)) {
//            binding.imageView2.setOnClickListener(null)
//        }


        val pref = activity?.getSharedPreferences("user", Context.MODE_PRIVATE)
        val user = pref?.getString("user", "")
        if (user != null) {
            if (user.isEmpty()) else {
                if (user == "invitado") {
                    binding.tvUsuario.text = ""
                }
                binding.tvUsuario.text = "Bienvenido\n$user"
            }

        }

    }

}

