package com.example.idadedecachorrokotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TITULO_APPBAR:String = "Idade de Cachorro Kotlin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle(TITULO_APPBAR)

        val caixaTexto:EditText = activity_editText_idade
        val calcularIdade:Button = activity_button_calcularIdade
        val resultado:TextView = activity_text_idade

        calcularIdade.setOnClickListener() {
            val textoDigitado:String? = caixaTexto.text.toString()

            val valorDigitado = if (textoDigitado.isNullOrEmpty())
                                    Toast.makeText(this,"Digite um texto", Toast.LENGTH_LONG).show()
                                else
                                    (resultado.setText("Idade: " + textoDigitado.toInt()*7))
        }

    }
}
