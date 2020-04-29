package annia.com.br.armazenamentodepreferncias;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botaoSalvar;
    private EditText textoNome;
    private TextView textoExibicao;

    //um atributo é estático, se a classe for instanciada várias vezes ele nao vai mudar
    //final define que o valor é final, não pode ser alterado
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoSalvar = findViewById(R.id.activity_botao_salvar);
        textoNome = findViewById(R.id.activity_nome_text);
        textoExibicao = findViewById(R.id.activity_texto_exibicao);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mode = 0 --> preferência privada, apenas para esse aplicativo
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //recuperamos o que foi digitado, convertemos para string e verificamos se ele é igual a null
                if(textoNome.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Por favor preencha o nome", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("nome", textoNome.getText().toString());
                    editor.commit();
                    textoExibicao.setText("Olá, " + textoNome.getText().toString());
                }
            }
        });

        //Recupera os dados salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

        if(sharedPreferences.contains("nome")) {
            String nomeUsuario = sharedPreferences.getString("nome", "Usuário Default");
            textoExibicao.setText("Olá, " + nomeUsuario);
        } else {
            textoExibicao.setText("Olá, Usuário não definido");
        }
    }
}
