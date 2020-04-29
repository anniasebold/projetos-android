package annia.com.br.caraoucoroa;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class JogoActivity extends AppCompatActivity {

    private ImageView botaoVoltar;
    private ImageView imageMoeda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        botaoVoltar = findViewById(R.id.activity_button_voltar);
        imageMoeda = findViewById(R.id.activity_moeda);

        Bundle extra = getIntent().getExtras();

        if( extra != null ){
            String opcaoEscolhida = extra.getString("opcao");
            if(opcaoEscolhida.equals("cara")){
                imageMoeda.setImageDrawable(ContextCompat.getDrawable(JogoActivity.this,R.drawable.moeda_cara));
            } else {
                imageMoeda.setImageDrawable(ContextCompat.getDrawable(JogoActivity.this,R.drawable.moeda_coroa));
            }
        }


        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
