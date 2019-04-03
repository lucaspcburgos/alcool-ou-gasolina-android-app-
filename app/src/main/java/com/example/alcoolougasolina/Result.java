package com.example.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String resultData = getIntent().getStringExtra("result");
        String detailsData = getIntent().getStringExtra("details");

        TextView result = (TextView) findViewById(R.id.textView4);
        TextView details = (TextView) findViewById(R.id.textView5);

        result.setText(resultData);
        details.setText(detailsData);

        Button back = (Button) findViewById(R.id.button2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
