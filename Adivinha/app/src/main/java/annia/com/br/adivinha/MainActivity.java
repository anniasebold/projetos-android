package annia.com.br.adivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Jogo de Adivinhar";
    private Button botaoJogar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoJogar = findViewById(R.id.activity_button_jogar);
        textoResultado = findViewById(R.id.ativity_number_random);

        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomico = new Random();

                int numeroAleatorio = randomico.nextInt(100);

                textoResultado.setText("Random Number " + numeroAleatorio);
            }
        });

        setTitle(TITULO_APPBAR);

    }
}
