package com.example.equipofutbol

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.equipofutbol.databinding.ActivityMainBinding
import com.example.equipofutbol.databinding.ImgDesplegableBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        setSupportActionBar(binding.toolbar)
        val cabecera = ImgDesplegableBinding.inflate(layoutInflater)


        val menuHost: MenuHost = this

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_principal, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.principal) {
                    val alerta = AlertDialog.Builder(this@MainActivity)
                    alerta.setTitle("¿Desea salir?")
                    alerta.setPositiveButton("si") { _, _ ->
                        finish()
                        val intent = Intent(this@MainActivity, LoginActivity::class.java)
                        startActivity(intent)
                    }
                    alerta.setNegativeButton("no", null)
                    alerta.create().show()
                    return true
                }
                return false
            }

        })


        binding.navview.addHeaderView(cabecera.root)
        cabecera.imageView5
        cabecera.tvfecha
        cabecera.tvusuariomainAc
        cabecera.card


        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.drawerlayout.isDrawerOpen(binding.navview)) {
                    binding.drawerlayout.closeDrawer(GravityCompat.START)
                } else {
                    finish()

                }
            }

        })
        //cabecera por xml
//        val header = binding.navview.getHeaderView(0)
//        val textView = header.findViewById<TextView>(R.id.fragmentBienvenido)

        val navController = findNavController(R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(
            setOf(

                R.id.fragmentBienvenido,
                R.id.fragmentEquipo,
                R.id.fragmentGaleria,
                R.id.fragmentContacto
            ), binding.drawerlayout
        )
//fecha actual
        val dia = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = dia.format(Date())
        cabecera.tvfecha.text = currentDate
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navview.setupWithNavController(navController)


//usuario que accede
        if (bundle != null) {
            if (bundle.containsKey("aficionado")) {
                val user = bundle.getString("aficionado")
                cabecera.tvusuariomainAc.text = user
            }
            if (bundle.containsKey("jugador")) {
                val user = bundle.getString("jugador")
                cabecera.tvusuariomainAc.text = user
            }
            if (bundle.containsKey("directivo")) {
                val user = bundle.getString("directivo")
                cabecera.tvusuariomainAc.text = user
            }
            if (bundle.containsKey("invitado")) {
                val user = bundle.getString("invitado")
                cabecera.tvusuariomainAc.text = user

            }
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}