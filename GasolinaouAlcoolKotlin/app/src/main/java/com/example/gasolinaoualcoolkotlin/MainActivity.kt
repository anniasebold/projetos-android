package com.example.gasolinaoualcoolkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val precoAlcool:EditText = activity_preco_Alcool
        val precoGasolina:EditText = activity_text_preco_Gasolina
        val botaoVerificar:Button = activity_button_verificar
        val textoResultado:TextView = activity_texto_resultado

        botaoVerificar.setOnClickListener() {
            val textoAlcool:String = precoAlcool.text.toString()
            val textoGasolina:String = precoGasolina.text.toString()

            if (textoAlcool.isNullOrEmpty() || textoGasolina.isNullOrEmpty())
                Toast.makeText(this,"Insira os dois valores", Toast.LENGTH_LONG)
            else
                if (textoAlcool.toFloat() > textoGasolina.toFloat())
                    textoResultado.setText("É melhor Gasolina")
                else
                    textoResultado.setText("É melhor álcool")
        }
    }
}
