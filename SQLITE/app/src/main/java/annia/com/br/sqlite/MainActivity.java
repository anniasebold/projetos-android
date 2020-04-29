package annia.com.br.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas ( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome VARCHAR(30), " +
                    "idade INTEGER(3) )");

            //Inserir dados
//            bancoDados.execSQL("INSERT INTO pessoas( nome,idade ) VALUES ( 'Samira', 38 )");
//            bancoDados.execSQL("INSERT INTO pessoas( nome,idade ) VALUES ( 'Joaquim', 56 )");
//            bancoDados.execSQL("INSERT INTO pessoas( nome,idade ) VALUES ( 'Mariana', 21 )");
//            bancoDados.execSQL("INSERT INTO pessoas( nome,idade ) VALUES ( 'Breno', 12 )");
//            bancoDados.execSQL("INSERT INTO pessoas( nome,idade ) VALUES ( 'Bruna', 17 )");
//            bancoDados.execSQL("INSERT INTO pessoas( nome,idade ) VALUES ( 'Marcos', 29 )");
//            bancoDados.execSQL("INSERT INTO pessoas( nome,idade ) VALUES ( 'Annia', 29 )");
//            bancoDados.execSQL("INSERT INTO pessoas( nome,idade ) VALUES ( 'Felipe', 22 )");

            //bancoDados.execSQL(" UPDATE pessoas SET idade = 28 WHERE nome like 'Samira' ");
            //bancoDados.execSQL(" DELETE FROM pessoas WHERE nome like 'Samira' ");

            //Recuperando itens
            Cursor cursor = bancoDados.rawQuery(
                    " SELECT * FROM pessoas",
                    null);

            //Recuperando indice da coluna
            int indiceColunaID = cursor.getColumnIndex("id");
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");

            //Retorna o cursor pro inicio
            cursor.moveToFirst();
            while (cursor != null) {
                Log.i("RESULTADO - ID", cursor.getString(indiceColunaID));
                Log.i("RESULTADO - nome", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade", cursor.getString(indiceColunaIdade));
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}
