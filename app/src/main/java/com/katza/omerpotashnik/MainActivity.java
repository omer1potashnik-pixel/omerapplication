package com.katza.omerpotashnik;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // הגדרת משתנים
    Button bt;
    ImageView iv;
    Switch sw;
    SeekBar seekBar;
    boolean visable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // שים לב: אם עדיין יש מסך שחור, אפשר לשים // לפני השורה הבאה
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        visable = true;
        initViews();
    }

    private void initViews() {
        iv = findViewById(R.id.iv);

        // שלב 3 במדריך (עמוד 11): רישום אובייקט ל-Context Menu
        // כאן אנחנו רושמים את התמונה (iv). לחיצה ארוכה עליה תפתח את התפריט.
        registerForContextMenu(iv);

        // שאר הרכיבים שלך
        sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) iv.setVisibility(View.INVISIBLE);
            else iv.setVisibility(View.VISIBLE);
        });

        seekBar = findViewById(R.id.sb);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                iv.setAlpha(progress / 100f);
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        bt = findViewById(R.id.btn1);
        bt.setOnClickListener(v -> {
            if (visable) iv.setVisibility(View.INVISIBLE);
            else iv.setVisibility(View.VISIBLE);
            visable = !visable;
        });
    }

    // ==========================================================
    // חלק א': Options Menu (התפריט למעלה - עמודים 8-10 במדריך)
    // ==========================================================

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // ניפוח התפריט מה-XML
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_login) {
            Toast.makeText(this, "You selected login (Options)", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // ==========================================================
    // חלק ב': Context Menu (לחיצה ארוכה - עמודים 11-14 במדריך)
    // ==========================================================

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // כותרת לתפריט שנפתח בלחיצה ארוכה
        menu.setHeaderTitle("Context Menu Action:");
        getMenuInflater().inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_register) {
            Toast.makeText(this, "Register selected via Long Press", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}