package com.example.oussama.baintrainerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView highScoreTextView;
    TextView newHighTextView;
    int highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = this.getPreferences(Context.MODE_PRIVATE);
        highScore = prefs.getInt("highscore", 0);

        highScoreTextView = (TextView) findViewById(R.id.textView);
        newHighTextView = (TextView) findViewById(R.id.textView2);
        newHighTextView.setText("");

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        if(score > highScore)
        {
            highScore = score;
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("highscore", highScore);
            editor.commit();
            newHighTextView.setText("Nieuwe high score!");
        }

        highScoreTextView.setText("HighScore: " + highScore);

    }


    public void Start(View view)
    {
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }
}
