package annia.com.br.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = findViewById(R.id.activity_button);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criando Alert Dialog
                dialog = new AlertDialog.Builder(MainActivity.this);

                //Configurar titulo
                dialog.setTitle("Título da Dialog");
                //Configurar a mensagem
                dialog.setMessage("Mensagem da Dialog");

                dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.btn_dialog);

                //Botão negativo
                dialog.setNegativeButton("Não",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Pressionado o Botão NÃO", Toast.LENGTH_LONG).show();
                            }
                        });
                dialog.setPositiveButton("Sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Pressionado o Botão SIM", Toast.LENGTH_LONG).show();
                            }
                        });
                dialog.show();
            }
        });
    }
}
