package com.example.adivinhakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val APP_BAR:String = "Adivinha Kotlin"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textoResultado:TextView = activity_textResultado
        val botaoJogar:Button = activity_button_play

        botaoJogar.setOnClickListener {
            val numeroAleatorio:Int = Random.nextInt(100)

            textoResultado.text = "Random Number: $numeroAleatorio"
        }

        setTitle(APP_BAR)

    }

}
