package annia.com.br.idadedecachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText caixaTexto;
    private Button botaoIdade;
    private TextView resultadoIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caixaTexto = findViewById(R.id.activity_text_idade);
        botaoIdade = findViewById(R.id.activity_button_calcular);
        resultadoIdade = findViewById(R.id.activity_text_resultado);

        botaoIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Recuperar o que foi digitado
                String textoDigitado = caixaTexto.getText().toString();

                if(textoDigitado.isEmpty()) {
                    //String vazia (mensagem de erro)
                    Toast.makeText(MainActivity.this, "Por favor, digite uma idade para calcular", Toast.LENGTH_SHORT).show();
                } else {
                    int valorDigitado = Integer.parseInt(textoDigitado);
                    int resultadoFinal = valorDigitado*7;

                    resultadoIdade.setText("A idade do cachorro em anos humanos é: " + resultadoFinal);
                }

            }
        });

    }
}
