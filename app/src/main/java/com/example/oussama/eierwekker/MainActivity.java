package com.example.oussama.eierwekker;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    int tijdtotaal, minuten, seconde;
    String tijd;
    CountDownTimer timer;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        tijdtotaal = 30;
        minuten = 0;
        seconde = 30;
        trackSeekbar();

    }

    public void trackSeekbar(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tijdtotaal = MainActivity.this.seekBar.getProgress();
                setTimer();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setTimer(){
        minuten = tijdtotaal /60;
        seconde = tijdtotaal %60;
        if(seconde < 10 && seconde > 0){
            tijd = "0"+ minuten +":0"+ seconde;
        }else if(seconde > 9){
            tijd = "0"+ minuten +":"+ seconde;
        }
        textView.setText(tijd);
    }



    public void startStopTimer(View view){

        if(timer != null){
            button.setText("Start");
            timer.cancel();
            timer = null;
        }else {
            button.setText("Stop");
            timer = new CountDownTimer(tijdtotaal * 1000 + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    tijdtotaal = (int) millisUntilFinished / 1000;
                    setTimer();
                }

                @Override
                public void onFinish() {
                    textView.setText("00:00");
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mediaPlayer.start();
                    button.setText("Start");
                }
            };
            timer.start();
        }
    }


}
