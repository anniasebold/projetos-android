package annia.com.br.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botaoResultado;
    private EditText precoAlcool;
    private EditText precoGasolina;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoResultado = findViewById(R.id.activity_button_resultado);
        precoAlcool = findViewById(R.id.activity_text_preco_alcool);
        precoGasolina = findViewById(R.id.activity_text_preco_gasolina);
        textoResultado = findViewById(R.id.activity_texto_resultado);

        botaoResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoAlcool = precoAlcool.getText().toString();
                String textoGasolina = precoGasolina.getText().toString();

                if(textoAlcool.isEmpty() || textoGasolina.isEmpty()) {
                    textoResultado.setText("Insira os dois valores");
                } else {
                    float valorAlcool = Float.parseFloat(textoAlcool);
                    float valorGasolina = Float.parseFloat(textoGasolina);
                    if(valorAlcool > valorGasolina){
                        textoResultado.setText("É melhor Gasolina");
                    } else {
                        textoResultado.setText("É melhor Alcool");

                    }

                }
            }
        });


    }
}
