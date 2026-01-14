package com.katza.omerpotashnik;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Mainactivity2 extends AppCompatActivity {

    // הגדרת המשתנים של רכיבי הממשק
    private EditText etName;
    private EditText etAge;
    private CheckBox cbIsMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // קישור המשתנים לרכיבים ב-XML (ודא שה-IDs תואמים ל-XML שלך)
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        cbIsMale = findViewById(R.id.cbIsMale);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // דוגמה לפונקציה ששולפת את הנתונים מהשדות
    private void getValues() {
        String name = etName.getText().toString();

        // המרת טקסט למספר (חשוב לבדוק שהשדה לא ריק במציאות)
        int age = Integer.parseInt(etAge.getText().toString());

        boolean isMale = cbIsMale.isChecked();
    }
}