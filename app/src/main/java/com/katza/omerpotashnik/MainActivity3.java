package com.katza.omerpotashnik;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        Button btnTypeA = findViewById(R.id.btnTypeA);
        Button btnTypeB = findViewById(R.id.btnTypeB);

        btnTypeA.setOnClickListener(v -> {
            Intent i = new Intent("com.katza.TYPE_A_1");
            startActivity(i);
        });

        btnTypeB.setOnClickListener(v -> {
            Intent i = new Intent("com.katza.TYPE_B");
            startActivity(i);
        });
    }
}
