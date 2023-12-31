package com.example.equipofutbol

import Jugador
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.equipofutbol.databinding.FragmentEquipoBinding

class FragmentEquipo : Fragment() {
    private lateinit var binding: FragmentEquipoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEquipoBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listado = mutableListOf(
            Jugador(
                "https://pbs.twimg.com/media/FLqUG2zXIAIGICS?format=jpg&name=small",
                "Clua",
                "Portero",
                1,
                "David Clua Pumar",
                "07/01/1995",
                "Vigo",
                "1.99",
                "85",
                "Burgos cf",
                "",
                "1",
                "escuelaestech",
                ""


            ),

            Jugador(
                "https://pbs.twimg.com/media/FLGVFofXoAMMysN?format=jpg&name=small",
                "Lacroux",
                "Lateral derecho",
                2,
                "Jany Lacroux",
                "26/02/1996",
                "Belgica",
                "1.82",
                "79",
                "Genk sub-19",
                "Lateral derecho que tambien se desenvuelve bien como central",
                "2",
                "",
                ""
            ),
            Jugador(
                "https://pbs.twimg.com/media/FHZTm9xXIAAHYW0?format=jpg&name=small",
                "Ginés",
                "Lateral izquierdo",
                3,
                "Angel Gines Alcalá",
                "19/06/1994",
                "Peralada(Girona)",
                "1.73",
                "70",
                "Girona FC",
                "Ha disputado mas de 100 partidos en segunda",
                "2",
                "escuelaestech",
                ""
            ),

            Jugador(
                "https://pbs.twimg.com/media/FGmE7UJWQAsm21C?format=jpg&name=small",
                "Guraya",
                "Defensa central",
                4,
                "Raul Guraya Gomez",
                "14/05/1988",
                "madrid",
                "1.83",
                "81",
                "Granada B",
                "Defensa central con gran experiencia en la categoria",
                "2",
                "",
                ""
            ),
            Jugador(
                "https://pbs.twimg.com/media/E6r_jBgWEAsGb1F?format=jpg&name=small",
                "Monjonell",
                "Defensa central",
                5,
                "Alba mopjonell Vila ",
                "06/06/1984",
                "Villar del arzovispo(Valencia)",
                "1.85",
                "80",
                "Guadalajara",
                "Trayectoria: Valencia C - Valencia B - Barcelona B- - Gimnástic Tarragona - C.D. Guadalajara",
                "2",
                "",
                ""
            ),
            Jugador(
                "https://pbs.twimg.com/media/E6rsruuWQAALwT0?format=jpg&name=small",
                "Mene",
                "Mediapunta",
                6,
                "Enzo meneghello Pelaez",
                "23/03/1989",
                "Santander",
                "1.84",
                "74",
                "Racing Santander B",
                "Centrocampista ofensivo con buena zurda",
                "3",
                "escuelaestech",
                ""
            ),
            Jugador(
                "https://pbs.twimg.com/media/E6rsruuWQAALwT0?format=jpg&name=small",
//                "https://pbs.twimg.com/media/E3n3rHxXwAchTUs?format=jpg&name=small",
                "Cimbrón",
                "Mediocentro",
                7,
                "manuel Cimbron Ortiz",
                "11/12/1984",
                "Albacete",
                "1.77",
                "74",
                "Valencia mestalla ",
                "Mediocentro de gran clase y muy técnico, que ayuda a sacar el balón jugado desde atrás",
                "3",
                "",
                ""
            ),
            Jugador(
                "https://pbs.twimg.com/media/E6rsruuWQAALwT0?format=jpg&name=small",
//                "https://pbs.twimg.com/media/E2tboRgXMAAvRQH?format=jpg&name=small",
                "Akeda",
                "Interior derecho",
                8,
                "Abdoulaye Akeda Opono",
                "04/07/1992",
                "Camerun",
                "1.75",
                "73",
                "Almeria B",
                "Jugador muy rápido y de desborde. Suele irse de sus rivales por velocidad.",
                "3",
                "",
                ""
            ),
            Jugador(
                "https://pbs.twimg.com/media/E6rsruuWQAALwT0?format=jpg&name=small",
//                "https://pbs.twimg.com/media/E2j3ZpoXoAQVL7_?format=jpg&name=small",
                "Guillamas",
                "Interior izquierdo",
                9,
                "Sergio Guillamas Urquijo",
                "16/01/1992",
                "Victoria-Gazteiz",
                "1.89",
                "73",
                "mallorca B",
                "A pesar de su altura, posee gran velocidad y regate en carrera. Jugador muy habilidoso, también útil en el juego aéreo",
                "3",
                "escuelaestech",
                ""
            ),
            Jugador(
                "https://pbs.twimg.com/media/E6rsruuWQAALwT0?format=jpg&name=small",
//                "https://pbs.twimg.com/media/EoLc10hXcAECXNq?format=jpg&name=small",
                "Pozo",
                "Delantero",
                10,
                "Victor Pozo Lopez",
                "14/11/1992",
                "Cordoba",
                "1.83",
                "78",
                "Cordoba CF",
                "Delantero con gran olfato de gol, la pasada temporada marcó 20 goles en la categoría de plata.",
                "4",
                "",
                ""
            ), Jugador(
                "https://pbs.twimg.com/media/E6rsruuWQAALwT0?format=jpg&name=small",
//                "https://pbs.twimg.com/media/EdodsQXXsAAxIJA?format=jpg&name=small",
                "Ari",
                "Segundo delantero",
                11,
                "Aristides martinez Lopez",
                "24/10/1985",
                "Granada",
                "1.76",
                "70",
                "CF motril",
                "Delantero habilidoso y de gran tecnica, bueno en el ultimo pase",
                "4",
                "escuelaestech",
                ""
            ), Jugador(
                "",
                "José Sierra",
                "Entrenador",
                12,
                "David Clua Pumar",
                "07/01/1995",
                "Vigo",
                "1.99",
                "85",
                "Burgos cf",
                "",
                "1",
                "escuelaestech",
                ""
            )

        )


        val adapter = JugadorAdapter()
        binding.jugadoresImg.adapter = adapter
        adapter.llenarLista(listado)

        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.jugadoresImg.layoutManager = layoutManager


    }

}