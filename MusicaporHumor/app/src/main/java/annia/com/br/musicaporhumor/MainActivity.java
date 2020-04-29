package annia.com.br.musicaporhumor;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButtonFeliz;
    private ToggleButton toggleButtonTriste;
    private MediaPlayer mediaPlayerFeliz;
    private MediaPlayer mediaPlayerTriste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButtonFeliz = findViewById(R.id.activity_toggleButton_feliz);
        toggleButtonTriste = findViewById(R.id.activity_toggleButton_triste);
        mediaPlayerFeliz = MediaPlayer.create(MainActivity.this, R.raw.so_os_loucos_sabem);
        mediaPlayerTriste = MediaPlayer.create(MainActivity.this, R.raw.i_miss_you);

        toggleButtonTriste.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(toggleButtonTriste.isChecked()) {
                    tocarMusicaTriste();
                } else {
                    pausarMusicaTriste();
                }
            }
        });

        toggleButtonFeliz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(toggleButtonFeliz.isChecked()) {
                    tocarMusicaFeliz();
                } else {
                    pausarMusicaFeliz();
                }
            }
        });


    }

    private void tocarMusicaTriste() {
        if(mediaPlayerTriste != null) {
            mediaPlayerTriste.start();
            toggleButtonTriste.setChecked(true);
        }
    }

    private void pausarMusicaTriste() {
        if(mediaPlayerTriste != null) {
            mediaPlayerTriste.pause();
            toggleButtonTriste.setChecked(false);
        }
    }

    private void tocarMusicaFeliz() {
        if(mediaPlayerFeliz != null) {
            mediaPlayerFeliz.start();
            toggleButtonFeliz.setChecked(true);
        }
    }

    private void pausarMusicaFeliz() {
        if(mediaPlayerFeliz != null) {
            mediaPlayerFeliz.pause();
            toggleButtonFeliz.setChecked(false);
        }
    }

    @Override
    protected void onDestroy() {

        if(mediaPlayerTriste != null && mediaPlayerTriste.isPlaying()) {
            mediaPlayerTriste.stop();
            mediaPlayerTriste.release();
            mediaPlayerTriste = null;
        }

        super.onDestroy();
    }
}
