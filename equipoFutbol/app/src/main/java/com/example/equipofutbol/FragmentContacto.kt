package com.example.equipofutbol

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.equipofutbol.databinding.FragmentContactoBinding


class FragmentContacto : Fragment() {

    private lateinit var binding: FragmentContactoBinding
    private lateinit var spinnerContacto: Spinner
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactoBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonMapa.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=38.0942291,-3.6311379")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)

        }
        binding.buttonCorreo.setOnClickListener {
            val recipient = "info@escuelaestech.es"
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))

            }
            startActivity(intent)

        }
        binding.buttonTelefono.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:953636000")
            startActivity(intent)
        }
        binding.buttonWhatsap.setOnClickListener {
            val phoneNumber = "697246008"
            val message = "Hola"
            val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=$message"

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        spinnerContacto = view.findViewById(R.id.spinnerContacto)
        val adapter = ArrayAdapter.createFromResource(
            requireContext(), R.array.opciones_spinner, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerContacto.adapter = adapter

        binding.btnenviar.setOnClickListener {
            if (!binding.checkBox.isChecked) {
                Toast.makeText(
                    this.requireContext(),
                    " debe aceptar los terminos",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            val opcionSeleccionada = binding.spinnerContacto.selectedItem.toString()
            val contenidoTextView = binding.mensaje.text.toString()

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(binding.correo.text.toString()))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo")
            val contenidoCorreo =
                "Opción seleccionada: $opcionSeleccionada\n\nContenido: $contenidoTextView"
            intent.putExtra(Intent.EXTRA_TEXT, binding.mensaje.text.toString())

            startActivity(Intent.createChooser(intent, "Enviar correo"))
        }
    }

}
