
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Jugador(
    val img : String,
    val nombre: String,
    val Posicion: String,
    val id: Int,
    val apodo: String,
    val fecha: String,
    val lugar: String,
    val altura:String,
    val peso: String,
    val procedencia: String,
    val descripcion: String,
    val pos : String,
    val twitter : String,
    val info : String
):Parcelable