package com.example.examen;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //setSupportActionBar(toolbar);
        if (toolbar == null) {
            Log.e("MainActivity", "Toolbar is null");
        } else {
            setSupportActionBar(toolbar);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Puesta de sol");
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        FrameLayout frameLayout = findViewById(R.id.sky);
        ImageView imageView = findViewById(R.id.sun);

        int color0 = ContextCompat.getColor(this, R.color.sky1);
        int color1 = ContextCompat.getColor(this, R.color.sky2);
        int color2 = ContextCompat.getColor(this, R.color.sky3);
        int color3 = ContextCompat.getColor(this, R.color.sky4);

        frameLayout.setOnClickListener(view -> {
            ObjectAnimator moveDownAnimator = ObjectAnimator.ofFloat(
                    imageView,
                    "translationY",
                    250f // Distance to move down (in pixels)
            );
            moveDownAnimator.setDuration(3000); // Duration of the animation
            moveDownAnimator.setInterpolator(new AccelerateDecelerateInterpolator());

            // Animate the FrameLayout's background color
            ValueAnimator colorAnimator = ValueAnimator.ofArgb(
                    color0,
                    color1,   // Start color
                    color2,
                    color3 // End color
            );
            colorAnimator.setDuration(3000); // Match duration with the move animation
            colorAnimator.addUpdateListener(animation -> {
                int color = (int) animation.getAnimatedValue();
                frameLayout.setBackgroundColor(color);
            });

            moveDownAnimator.start();
            colorAnimator.start();
        });
    }
}