package annia.com.br.qualserie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button gerarSerie;
    private SeekBar seekBar;
    private ImageView imagemResultado;
    private TextView nomeSerie;

    private String[] series= {
            "Friends", "Breaking Bad", "Arquivo X",
            "Game of Thrones", "Mad Men", "Os Simpsons",
            "Grey’s Anatomy", "House of Cards", "Orange Is the New Black",
            "Family Guy", "Três é Demais", "Você", "The Witcher", "The Good Doctor",
            "Vikings", "Riverdale", "Vis a Vis", "The 100", "Rick and Morty"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gerarSerie = findViewById(R.id.activity_gerar_nova_serie);
        seekBar = findViewById(R.id.activity_seekBar);
        imagemResultado = findViewById(R.id.activity_imagem_resultado);
        nomeSerie = findViewById(R.id.activity_nome_série);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress < 5) {
                    imagemResultado.setImageResource(R.drawable.pouco);
                } else if(progress >= 5 && progress <= 8) {
                    imagemResultado.setImageResource(R.drawable.medio);
                } else {
                    imagemResultado.setImageResource(R.drawable.muito);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        gerarSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomico = new Random();
                int numeroRandom = randomico.nextInt(series.length);

                nomeSerie.setText(series[numeroRandom]);
            }
        });
    }
}
