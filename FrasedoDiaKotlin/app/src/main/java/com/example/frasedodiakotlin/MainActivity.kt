package com.example.frasedodiakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val frases = arrayOf(
        "A persistência é o caminho do êxito.",
        "O sucesso nasce do querer, da determinação e persistência em se chegar a um objetivo.",
        "Mesmo não atingindo o alvo, quem busca e vence obstáculos, no mínimo fará coisas admiráveis.",
        "Determinação, coragem e autoconfiança são fatores decisivos para o sucesso. Se estamos possuídos por uma inabalável determinação, conseguiremos superá-los." ,
        "Independentemente das circunstâncias, devemos ser sempre humildes, recatados e despidos de orgulho.",
        "Agir, eis a inteligência verdadeira. Serei o que quiser. Mas tenho que querer o que for. O êxito está em ter êxito, e não em ter condições de êxito.",
        " Condições de palácio tem qualquer terra larga, mas onde estará o palácio se não o fizerem ali?",
        "Só existe um êxito: a capacidade de levar a vida que se quer.",
        "A vitalidade é demonstrada não apenas pela persistência, mas pela capacidade de começar de novo.",
        "A coragem não é ausência do medo; é a persistência apesar do medo.",
        "O homem não teria alcançado o possível se, repetidas vezes, não tivesse tentado o impossível.",
        "Só se pode alcançar um grande êxito quando nos mantemos fiéis a nós mesmos.",
        "Todo mundo é capaz de sentir os sofrimentos de um amigo. Ver com agrado os seus êxitos exige uma natureza muito delicada.",
        "Creia em si, mas não duvide sempre dos outros.",
        "Dois homens não podem passar meia hora juntos sem que um conquiste uma evidente superioridade em relação ao outro.",
        "Talento é dom, é graça. E sucesso nada tem haver com sorte, mas com determinação e trabalho.",
        "Nenhum mentiroso tem uma memória suficientemente boa para ser um mentiroso de êxito.",
        "Estar decidido, acima de qualquer coisa, é o segredo do êxito.",
        "A disciplina é a mãe do êxito.",
        "Para obter êxito no mundo temos de parecer loucos mas sermos espertos.",
        "O êxito começa no exato momento em que o homem decide o que quer e começa a trabalhar para consegui-lo.",
        "Tudo deveria se tornar o mais simples possível, mas não simplificado.",
        "Como se fosse possível matar o tempo sem ferir a eternidade.",
        "O que mais desespera não é o impossível. Mas o possível não alcançado.",
        "Há poucos homens capazes de prestar homenagem ao sucesso de um amigo, sem qualquer inveja."
    )

    private val TITULO_APPBAR:String = "Frase do Dia Kotlin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val novaFrase: Button = activity_button_novaFrase
        val textoFrase = activity_text

        novaFrase.setOnClickListener() {
            val tamanho:Int = Random.nextInt(frases.size)

            textoFrase.text = frases[tamanho]
        }

        setTitle(TITULO_APPBAR)
    }
}
