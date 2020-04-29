package annia.com.br.preferenciascorusuario;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonSelecionado;
    private Button botaoSalvar;
    private RelativeLayout layout;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.activity_radiogroup);
        botaoSalvar = findViewById(R.id.activity_botao_salvar);
        layout = findViewById(R.id.activity_layout);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();

                if (idRadioButtonEscolhido > 0) {
                    radioButtonSelecionado = findViewById(idRadioButtonEscolhido);

                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    String corEscolhida = radioButtonSelecionado.getText().toString();

                    editor.putString("corEscolhida", corEscolhida);
                    editor.commit();

                    setBackground(corEscolhida);

                }

            }
        });

        //Recuperar os dados salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

        if(sharedPreferences.contains("corEscolhida")) {
            String corRecuperada = sharedPreferences.getString("corEscolhida", "Laranja");
            setBackground( corRecuperada );
        } else {
            setBackground("Azul");
        }


    }

    private void setBackground(String cor) {
        if(cor.equals("Azul")) {
            layout.setBackgroundColor(Color.parseColor("#495B7C"));
        } else if(cor.equals("Laranja")) {
            layout.setBackgroundColor(Color.parseColor("#FFCE26"));
        } else if(cor.equals("Verde")) {
            layout.setBackgroundColor(Color.parseColor("#009670"));
        }
    }

}
