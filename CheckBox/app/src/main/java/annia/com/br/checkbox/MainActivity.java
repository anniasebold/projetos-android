package annia.com.br.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botaoMostrar;
    private CheckBox checkboxCao;
    private CheckBox checkboxGato;
    private CheckBox checkboxPapagaio;
    private CheckBox checkboxCobra;
    private CheckBox checkboxHamster;
    private TextView textoExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoMostrar = findViewById(R.id.activity_botao_mostrar);
        textoExibicao = findViewById(R.id.activity_mostrar_selecionado);

        checkboxCao = findViewById(R.id.activity_checkbox_cao);
        checkboxGato = findViewById(R.id.activity_checkbox_gato);
        checkboxPapagaio = findViewById(R.id.activity_checkbox_papagaio);
        checkboxCobra = findViewById(R.id.activity_checkbox_cobra);
        checkboxHamster = findViewById(R.id.activity_checkbox_hamster);

        botaoMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String itensSelecionados = "";

                itensSelecionados += "Item: " + checkboxCao.getText() + ": " + checkboxCao.isChecked() ;
                itensSelecionados += "\nItem: " + checkboxGato.getText() + ": " + checkboxGato.isChecked();
                itensSelecionados += "\nItem: " + checkboxPapagaio.getText() + ": " + checkboxPapagaio.isChecked() ;
                itensSelecionados += "\nItem: " + checkboxCobra.getText() + ": " + checkboxCobra.isChecked() ;
                itensSelecionados += "\nItem: " + checkboxHamster.getText() + ": " + checkboxHamster.isChecked() ;

                textoExibicao.setText(itensSelecionados);

            }
        });

    }
}
