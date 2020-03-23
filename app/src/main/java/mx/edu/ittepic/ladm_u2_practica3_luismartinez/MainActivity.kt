package mx.edu.ittepic.ladm_u2_practica3_luismartinez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var dados = arrayOf(
        R.drawable.d1,
        R.drawable.d2,
        R.drawable.d3,
        R.drawable.d4,
        R.drawable.d5,
        R.drawable.d6
    )
    var sumaDados=0
    var lanzamiento=0
    var turno=1
    var tituloturno=1
    var ptsP1 = 0
    var ptsP2 = 0
    var ptsP3 = 0
    var ptsP4 = 0
    var ganador=ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        comenzar.setOnClickListener {

            while (turno<5){
                while (lanzamiento<5){
                    var hiloAsincrono = HiloAsincrono(this)
                    hiloAsincrono.execute(lanzamiento, lanzamiento, lanzamiento)
                    lanzamiento++
                }//whileLanzamiento
                turno++
                lanzamiento=1
            }//whileTurno


        }//seOnClickListener
    }//onCreate
    fun lanzarDados() {
        var d1 = (0..5).random()
        var d2 = (0..5).random()
        dado1.setImageResource(dados[d1])
        dado2.setImageResource(dados[d2])
       sumaDados = (d1 + d2) + 2

    }//lanzarDados
    fun elegirGanador(){
        if(ganador[0]==ganador.max()){
            this.setTitle("Ganador: jugador 1")
        }//if1
        if(ganador[1]==ganador.max()){
            this.setTitle("Ganador: jugador 2")
        }//if1
        if(ganador[2]==ganador.max()){
            this.setTitle("Ganador: jugador 3")
        }//if1
        if(ganador[3]==ganador.max()){
            this.setTitle("Ganador: jugador 4")
        }//if1

    }


}
