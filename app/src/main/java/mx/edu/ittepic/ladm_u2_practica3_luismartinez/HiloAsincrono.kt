package mx.edu.ittepic.ladm_u2_practica3_luismartinez

import android.os.AsyncTask

import kotlinx.android.synthetic.main.activity_main.*

class HiloAsincrono(p: MainActivity) : AsyncTask<Int, String, Int>() {
    var puntero = p
    override fun onPreExecute() {
        super.onPreExecute()

    }//onPreExecute
    override fun doInBackground(vararg params: Int?): Int {
        publishProgress(params[0].toString())
        return params[0]!!
    }//doInBackground

    override fun onProgressUpdate(vararg values: String?) {
        super.onProgressUpdate(*values)

        if(values[0].toString()=="1"){
            puntero.image1.setImageResource(R.drawable.on)
            puntero.textEstado1.setText("Jugando")
            puntero.textEstado2.setText("Esperando...")
            puntero.textEstado3.setText("Esperando...")
            puntero.textEstado4.setText("Esperando...")
            puntero.image2.setImageResource(R.drawable.player)
            puntero.image3.setImageResource(R.drawable.player)
            puntero.image4.setImageResource(R.drawable.player)


        }//if1
        if(values[0].toString()=="2"){
            puntero.image2.setImageResource(R.drawable.on)
            puntero.textEstado2.setText("Jugando")
            puntero.textEstado1.setText("Esperando...")
            puntero.textEstado3.setText("Esperando...")
            puntero.textEstado4.setText("Esperando...")
            puntero.image1.setImageResource(R.drawable.player)
            puntero.image3.setImageResource(R.drawable.player)
            puntero.image4.setImageResource(R.drawable.player)
        }//if2
        if(values[0].toString()=="3"){
            puntero.image3.setImageResource(R.drawable.on)
            puntero.textEstado3.setText("Jugando")
            puntero.textEstado1.setText("Esperando...")
            puntero.textEstado2.setText("Esperando...")
            puntero.textEstado4.setText("Esperando...")
            puntero.image1.setImageResource(R.drawable.player)
            puntero.image2.setImageResource(R.drawable.player)
            puntero.image4.setImageResource(R.drawable.player)
        }//if3
        if(values[0].toString()=="4"){
            puntero.image4.setImageResource(R.drawable.on)
            puntero.textEstado4.setText("Jugando")
            puntero.textEstado1.setText("Esperando...")
            puntero.textEstado2.setText("Esperando...")
            puntero.textEstado3.setText("Esperando...")
            puntero.image1.setImageResource(R.drawable.player)
            puntero.image2.setImageResource(R.drawable.player)
            puntero.image3.setImageResource(R.drawable.player)
        }//if4
    }//onProgressUpdate

    override fun onPostExecute(result: Int?) {

        super.onPostExecute(result)
        if(result==1){
            puntero.setTitle("Turno: "+(puntero.tituloturno))
            puntero.tituloturno++
            puntero.lanzarDados()
            puntero.txtPuntos1.setText((puntero.txtPuntos1.text.toString().toInt() + puntero.sumaDados).toString())
            puntero.ptsP1=puntero.txtPuntos1.text.toString().toInt()


        }
        if(result==2){
            puntero.lanzarDados()
            puntero.txtPuntos2.setText((puntero.txtPuntos2.text.toString().toInt() + puntero.sumaDados).toString())
            puntero.ptsP2=puntero.txtPuntos2.text.toString().toInt()
        }
        if(result==3){
            puntero.lanzarDados()
            puntero.txtPuntos3.setText((puntero.txtPuntos3.text.toString().toInt() + puntero.sumaDados).toString())
            puntero.ptsP3=puntero.txtPuntos3.text.toString().toInt()

        }

        if(result==4){
            puntero.lanzarDados()
            puntero.txtPuntos4.setText((puntero.txtPuntos4.text.toString().toInt() + puntero.sumaDados).toString())
            puntero.ptsP4=puntero.txtPuntos4.text.toString().toInt()

            if(puntero.tituloturno>4){

                puntero.ganador.add(puntero.ptsP1)
                puntero.ganador.add(puntero.ptsP2)
                puntero.ganador.add(puntero.ptsP3)
                puntero.ganador.add(puntero.ptsP4)
                puntero.textEstado1.setText("Finalizado")
                puntero.textEstado2.setText("Finalizado")
                puntero.textEstado3.setText("Finalizado")
                puntero.textEstado4.setText("Finalizado")
                puntero.image1.setImageResource(R.drawable.player)
                puntero.image2.setImageResource(R.drawable.player)
                puntero.image3.setImageResource(R.drawable.player)
                puntero.image4.setImageResource(R.drawable.player)
                puntero.elegirGanador()
            }
        }

        Thread.sleep(2000)







    }
}//class