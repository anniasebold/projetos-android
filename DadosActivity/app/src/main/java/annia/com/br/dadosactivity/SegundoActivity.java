package annia.com.br.dadosactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        texto = findViewById(R.id.activity_text);
        Bundle extra = getIntent().getExtras();

        if(extra != null) {
            String textoPassado = extra.getString("nome");
            texto.setText(textoPassado);
        } else {
            texto.setText("Não há nada para passar");
        }


    }
}
