package com.example.alcoolougasolina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcular = (Button) findViewById(R.id.button);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText gasolinaInput = (EditText) findViewById(R.id.editText);
                EditText alcoolInput = (EditText) findViewById(R.id.editText3);
//                Log.d("asd","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + gasolina);

                double gasolina = Double.parseDouble(gasolinaInput.getText().toString());
                double alcool = Double.parseDouble(alcoolInput.getText().toString());

                String result;
                double limit = gasolina*0.74;

                if (alcool < limit) {
                    result = "Álcool é melhor!";
                } else {
                    if (alcool == limit) {
                        result = "Equivalentes";
                    } else {
                        result = "Gasolina é melhor!";
                    }
                }

                double proportion = alcool/gasolina;
                String proportionFormat = new DecimalFormat("#.##").format(proportion*100);
                String details = "O preço do álcool equivale a " + proportionFormat + "% do preço da gasolina.";

                Intent goToResult = new Intent(MainActivity.this, Result.class);
                goToResult.putExtra("result", result);
                goToResult.putExtra("details", details);

                startActivity(goToResult);
            }
        });

    }



}
