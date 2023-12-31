package com.example.equipofutbol

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.equipofutbol.databinding.LoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pref = getSharedPreferences("user", Context.MODE_PRIVATE)
        val user = pref.getString("user", "")
        binding.logUsuario.setText(user)

        binding.buttonInvitados.setOnClickListener {
            binding.logUsuario.setText("")
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("invitado","invitado")
            startActivity(intent)
            finish()

        }

        binding.buttonLogin.setOnClickListener {
            when (binding.logUsuario.text.toString()) {
                "aficionado" -> if (binding.logContraseA.text.toString() == "123456") {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("aficionado","aficionado")
                    recuperar()
                    startActivity(intent)
                    finish()


                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    binding.logUsuario.error="datos incorrectos"
                    binding.logContraseA.error= "datos incorrectos"
                }
                "jugador" -> if (binding.logContraseA.text.toString() == "qwerasdf") {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("jugador","jugador")
                    recuperar()
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    binding.logUsuario.error="datos incorrectos"
                    binding.logContraseA.error= "datos incorrectos"
                }
                "directivo" -> if (binding.logContraseA.text.toString() == "asdfasdf") {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("directivo","directivo")
                    recuperar()
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    binding.logUsuario.error="datos incorrectos"
                    binding.logContraseA.error= "datos incorrectos"
                }
                else -> Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun recuperar() {
        val pref = getSharedPreferences("user", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("user", binding.logUsuario.text.toString())
        editor.apply()
        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
    }


}