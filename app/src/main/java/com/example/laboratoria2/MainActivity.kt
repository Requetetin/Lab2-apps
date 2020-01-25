package com.example.laboratoria2

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var nCounter = 0 //Contador a mostrar en pantalla


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val longClick : Button=findViewById(R.id.count_button) //Instancia del boton para detectar longclick

        //Si detecta un long click en el boton de contar, encuentra la diferencia entre 20 y el contador y lo muestra en un toast
        longClick.setOnLongClickListener {
            var oCounter = 20 - nCounter
            toastOnLongClick("Faltan $oCounter vueltas")
        }


    }

        //Si se hace el longclick, esta funcion se encarga de mostrar el toast
    fun toastOnLongClick(text:CharSequence):Boolean{
        Toast.makeText(applicationContext,text,Toast.LENGTH_SHORT).show()
        return true
    }


        //A cada presion del boton de contar, se utiliza esta funcion
    fun countUp(view: View) {
        nCounter ++
        val countView = findViewById(R.id.contador) as TextView
        val trophyView = findViewById<ImageView>(R.id.trofeo)
        if(nCounter == 10){//Si el contador es 10, muestra imagen y toast
            trophyView.setImageResource(R.drawable.running)
            countView.text = "$nCounter"
            Toast.makeText(this, "Ya vamos a la mitad", Toast.LENGTH_SHORT).show()
        }
        else if (nCounter == 20){//Cuando llega a 20, se actualiza la imagen y se muestra un nuevo toast
            trophyView.setImageResource(R.drawable.trophy)
            countView.text = "$nCounter"
            Toast.makeText(this, "Ya hemos terminado", Toast.LENGTH_SHORT).show()
        }
        else if (nCounter<21){//Aqui no deja que suba de 20 el contador
            countView.text = "$nCounter"
        }
        else{//Y si pasa de 20, lo regresa a este mismo numero
            nCounter = 20
        }

    }

    fun resetView(view: View) {//Esta funcion esta engargada de regresar el contador a 0 y quitar las imagenes mostradas en pantalla
        val countView = findViewById(R.id.contador) as TextView
        val trophyView = findViewById<ImageView>(R.id.trofeo)
        countView.text = "0"
        trophyView.setImageResource(R.drawable.transparent)
        nCounter = 0

    }




}
