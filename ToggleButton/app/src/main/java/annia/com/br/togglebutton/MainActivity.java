package annia.com.br.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private TextView textoExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.activity_toggleButton);
        textoExibicao = findViewById(R.id.activity_textView);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                textoExibicao.setText("");
                if(toggleButton.isChecked()) {
                    textoExibicao.setText("Está Ligado");
                } else {
                    textoExibicao.setText("Está Desligado");
                }
            }
        });

    }
}
