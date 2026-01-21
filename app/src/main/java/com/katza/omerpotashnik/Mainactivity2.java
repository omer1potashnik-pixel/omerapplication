package com.katza.omerpotashnik;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Mainactivity2 extends AppCompatActivity {

    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);  // כאן מותאם לשם הקובץ activity_main2.xml

        etName = findViewById(R.id.etName);
    }
}
