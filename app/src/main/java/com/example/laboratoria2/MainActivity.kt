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

    var nCounter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val longClick : Button=findViewById(R.id.count_button)



        longClick.setOnLongClickListener {
            var oCounter = 20 - nCounter
            toastOnLongClick("Faltan $oCounter vueltas")
        }


    }

    fun toastOnLongClick(text:CharSequence):Boolean{
        Toast.makeText(applicationContext,text,Toast.LENGTH_SHORT).show()
        return true
    }


    fun countUp(view: View) {
        nCounter ++
        val countView = findViewById(R.id.contador) as TextView
        val trophyView = findViewById<ImageView>(R.id.trofeo)
        if(nCounter == 10){
            trophyView.setImageResource(R.drawable.running)
            countView.text = "$nCounter"
            Toast.makeText(this, "Ya vamos a la mitad", Toast.LENGTH_SHORT).show()
        }
        else if (nCounter == 20){
            trophyView.setImageResource(R.drawable.trophy)
            countView.text = "$nCounter"
            Toast.makeText(this, "Ya hemos terminado", Toast.LENGTH_SHORT).show()
        }
        else if (nCounter<21){
            countView.text = "$nCounter"
        }
        else{
            nCounter = 20
        }

    }

    fun resetView(view: View) {
        val countView = findViewById(R.id.contador) as TextView
        val trophyView = findViewById<ImageView>(R.id.trofeo)
        countView.text = "0"
        trophyView.setImageResource(R.drawable.transparent)
        nCounter = 0

    }




}
