package annia.com.br.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaItens;
    private String[] itens = {
            "Angra dos Reis", "Caldas Novas", "Campos do Jordão",
            "Costa do Sauípe", "Ilhéus", "Porto Seguro", "Rio de Janeiro",
            "Tiradentes", "Praga", "Santiago", "Caribe", "Buenos Aires",
            "Budapest", "Cancun", "Aruba"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItens = findViewById(R.id.activity_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                //layout que já vem com o Android
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );
        listaItens.setAdapter(adapter);

        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorClicado = listaItens.getItemAtPosition(position).toString();
                Toast makeText = Toast.makeText(getApplicationContext(), valorClicado, Toast.LENGTH_SHORT);
                makeText.show();
            }
        });

    }
}
