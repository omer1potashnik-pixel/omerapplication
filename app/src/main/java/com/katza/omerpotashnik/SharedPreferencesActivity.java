package com.katza.omerpotashnik;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

    public class SharedPreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences sp;
    Button btnSave;
    EditText etFname, etLname;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_preffrences);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // אתחול הרכיבים
        btnSave = findViewById(R.id.btnSubmit);
        etFname = findViewById(R.id.etFname);
        etLname = findViewById(R.id.etLname);
        tvDisplay = findViewById(R.id.tvDisplay);

        // הגדרת מאזין לכפתור
        btnSave.setOnClickListener(this);

        //----------------------------------------
        // יצירת תיקייה בשם details1
        //----------------------------------------
        sp = getSharedPreferences("details1", 0);

        //----------------------------------------
        // טעינת נתונים אם קיימים
        //----------------------------------------
        String strfname = sp.getString("fname", null);
        String strlname = sp.getString("lname", null);

        if (strfname != null && strlname != null) {
            tvDisplay.setText("welcome " + strfname + " " + strlname);
        }
    }

    //----------------------------------------
    // שמירת נתונים בלחיצה על הכפתור (כמו בתמונה)
    //----------------------------------------
    @Override
    public void onClick(View v) {
        if (btnSave == v) {

            SharedPreferences.Editor editor = sp.edit();

            editor.putString("fname", etFname.getText().toString());
            editor.putString("lname", etLname.getText().toString());

            editor.commit(); // שמירה בפועל
        }
    }
}
