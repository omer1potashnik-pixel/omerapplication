package com.katza.omerpotashnik;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DynamicActivity extends AppCompatActivity {

    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dynamic);

        mainLayout = findViewById(R.id.main);

        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        LinearLayout.LayoutParams hsParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        horizontalScrollView.setLayoutParams(hsParams);

            LinearLayout llScroll = new LinearLayout(this);
       LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
       llScroll.setLayoutParams(llParams);
       llScroll.setOrientation(LinearLayout.HORIZONTAL);


        for (int i = 1; i <= 50; i++) {

            ImageView imageView = new ImageView(this);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(300, 300);
            params.setMargins(5, 5, 5, 5);
            imageView.setLayoutParams(params);

            // assumes img1, img2, img3 exist in drawable
            int imageKey = getResources().getIdentifier("img" + i%3, "drawable", getPackageName());

            imageView.setImageResource(imageKey);
            llScroll.addView(imageView);
        }
        horizontalScrollView.addView(llScroll);
        mainLayout.addView(horizontalScrollView);
    }
}
