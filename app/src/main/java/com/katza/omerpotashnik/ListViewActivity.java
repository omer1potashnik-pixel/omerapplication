package com.katza.omerpotashnik;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private ExamAdapter adapter;
    private List<Exam> examList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. קישור ה-ListView מה-XML
        listView = findViewById(R.id.listViewExams);

        // 2. יצירת רשימת נתונים לדוגמה
        examList = new ArrayList<>();
        examList.add(new Exam("מתמטיקה בדידה", 85));
        examList.add(new Exam("מבני נתונים", 55)); // נכשל
        examList.add(new Exam("פיתוח באנדרואיד", 100));
        examList.add(new Exam("מערכות הפעלה", 72));
        examList.add(new Exam("רשתות תקשורת", 45)); // נכשל
        examList.add(new Exam("מתמטיקה בדידה", 85));
        examList.add(new Exam("מבני נתונים", 55)); // נכשל
        examList.add(new Exam("פיתוח באנדרואיד", 100));
        examList.add(new Exam("מערכות הפעלה", 72));
        examList.add(new Exam("רשתות תקשורת", 45)); // נכשל

        // 3. אתחול ה-Adapter המותאם אישית שלנו
        adapter = new ExamAdapter(this, examList);

        // 4. חיבור ה-Adapter ל-ListView
        listView.setAdapter(adapter);

    }
}