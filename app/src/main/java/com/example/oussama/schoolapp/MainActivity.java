package com.example.oussama.schoolapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Button euroNaarDollar = (Button) findViewById(R.id.euroNaarDollar);
        final Button dollarNaarEuro = (Button) findViewById(R.id.dollarNaarEuro);
        final EditText invoer  = (EditText) findViewById(R.id.invoer);
        final TextView resultaat = (TextView) findViewById(R.id.resultaat);
        Double invoerDouble = Double.parseDouble(invoer.getText().toString());



        if(!invoerDouble.equals("")){
           invoerDouble = 0.00;
        }

        euroNaarDollar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Double invoerDouble = Double.parseDouble(invoer.getText().toString());
                double d = invoerDouble *  1.10;
                String.format("%.2f", d);
                resultaat.setText("" + d);
            }

        });

        dollarNaarEuro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Double invoerDouble = Double.parseDouble(invoer.getText().toString());
                double d = invoerDouble * 0.90;
                String.format("%.2f", d);
                resultaat.setText("" + d);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
