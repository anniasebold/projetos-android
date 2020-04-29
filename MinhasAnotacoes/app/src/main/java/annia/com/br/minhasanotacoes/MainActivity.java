package annia.com.br.minhasanotacoes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout layout;
    private EditText editText;
    private ImageView botaoSalvar;
    private static final String NOME_ARQUIVO = "arquivo_anotacao.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.activity_layout);
        editText = findViewById(R.id.activity_editText);
        botaoSalvar = findViewById(R.id.activity_botao_salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDigitado = editText.getText().toString();
                gravarNoArquivo(textoDigitado);
                Toast.makeText(MainActivity.this, "Anotação salva com sucesso", Toast.LENGTH_LONG).show();

            }
        });

        //Recuperar o que foi gravado
        if(lerArquivo() != null) {
            editText.setText(lerArquivo());
        }





    }

    private void gravarNoArquivo(String texto) {
        try {
            /* Primeiramente, instanciamos a classe OutputSreamWriter, instanciamos a classe
              -- No construtor da classe passar o arquivo que queremos, utilizando o metódo,
              -- Inserindo o nome do arquivo e o mode,
              -- Após isso utilizamos o método write para inserir no arquivo o que desejamos
              -- Após isso finalizamos a gravação no arquivo */
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    openFileOutput(NOME_ARQUIVO, Context.MODE_PRIVATE));
            outputStreamWriter.write( texto );
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.v("MainActivity", e.toString());
        }
    }

    private String lerArquivo() {

        String resultado="";

        try {
            //Abrir o arquivo
            InputStream arquivo = openFileInput(NOME_ARQUIVO);

            if(arquivo != null) {

                //Ler o arquivo
                InputStreamReader inputStreamReader = new InputStreamReader( arquivo );

                //Gerar Buffer do arquivo lido
                BufferedReader bufferedReader = new BufferedReader( inputStreamReader );

                //Recuperar textos do arquivo
                String linhaArquivo = "";
                while( (linhaArquivo = bufferedReader.readLine()) != null ){
                    resultado += linhaArquivo;
                }

                arquivo.close();

            }

        } catch (IOException e) {
            Log.v("MainActivity", e.toString());
        }


        return resultado;
    }
}
