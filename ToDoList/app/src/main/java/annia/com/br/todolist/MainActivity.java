package annia.com.br.todolist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button botaoAdicionar;
    private EditText textoTarefa;
    private ListView listaTarefas;
    private SQLiteDatabase database;

    private ArrayAdapter<String> itensAdapter;
    private ArrayList<String> itens;
    private ArrayList<Integer> ids;
    private static final String TITULO_APPBAR = "Lista de Tarefas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(TITULO_APPBAR);

        try {

            textoTarefa = findViewById(R.id.activity_editText);
            botaoAdicionar = findViewById(R.id.activity_button_adicionar);
            listaTarefas = findViewById(R.id.activity_lista_tarefas);

            //Banco de dados --> Parametros: nome da database, mode, factory
            database = openOrCreateDatabase("apptarefas", MODE_PRIVATE, null);

            //Criando tabela
            database.execSQL("CREATE TABLE IF NOT EXISTS tarefas (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "tarefa VARCHAR )");

            botaoAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Recuperando texto que foi digitado
                    String textoDigitado = textoTarefa.getText().toString();
                    saveTasks(textoDigitado);
                }
            });

            listaTarefas.setLongClickable(true);
            listaTarefas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    deleteTasks(ids.get(position));
                    return true;
                }
            });

            //Recuperar tarefas
            recoverTasks();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveTasks(String texto) {

        try {

            if(texto.equals("")) {
                Toast.makeText(MainActivity.this, "Digite uma tarefa", Toast.LENGTH_SHORT).show();
            } else {
                database.execSQL("INSERT INTO tarefas (tarefa) VALUES ('" + texto + "')");
                Toast.makeText(MainActivity.this, "Tarefa adicionada com sucesso", Toast.LENGTH_SHORT).show();
                recoverTasks();
                textoTarefa.setText("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void recoverTasks() {

        try {

            Cursor cursor = database.rawQuery("SELECT * FROM tarefas ORDER BY id DESC", null);

            //Recuperar os IDs das colunas
            int indiceColunaID = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            //Criar adaptador
            itens = new ArrayList<String>();
            ids = new ArrayList<Integer>();
            itensAdapter = new ArrayAdapter<String >(getApplicationContext(),
                    android.R.layout.simple_list_item_2,
                    android.R.id.text1,
                    itens);
            listaTarefas.setAdapter( itensAdapter );

            //Listar as tarefas
            cursor.moveToFirst();
            while(cursor != null) {
                Log.i("Resultado ","Tarefa: " + cursor.getString(indiceColunaTarefa));
                itens.add( cursor.getString( indiceColunaTarefa ) );
                ids.add(Integer.parseInt(cursor.getString(indiceColunaID)));
                cursor.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteTasks(Integer id) {
        try {
            database.execSQL("DELETE FROM tarefas WHERE id =" + id);
            recoverTasks();
            Toast.makeText(MainActivity.this, "Tarefa removida com sucesso", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
