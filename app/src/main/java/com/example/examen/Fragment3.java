package com.example.examen;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Fragment3 extends Fragment {
    private SeekBar azul;
    private SeekBar verde;
    private SeekBar rojo;
    private Button btnGetValue;
    private TextView valueTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment3, container, false);

        azul = rootView.findViewById(R.id.azul);
        verde = rootView.findViewById(R.id.verde);
        rojo = rootView.findViewById(R.id.rojo);

        btnGetValue = rootView.findViewById(R.id.button2);
        valueTextView = rootView.findViewById(R.id.textView2);

        // Set SeekBar color
        setSeekBarColor(azul, getResources().getColor(R.color.realblue));
        setSeekBarColor(verde, getResources().getColor(R.color.green));
        setSeekBarColor(rojo, getResources().getColor(R.color.red));
        // Set listener on the Button to get SeekBar value
        btnGetValue.setOnClickListener(view -> {
            int blu = azul.getProgress();
            int grin = verde.getProgress();
            int redd = rojo.getProgress();
            String hex = Integer.toHexString(redd)+Integer.toHexString(grin)+Integer.toHexString(blu);
            System.out.println(hex);
            //rrggbb
           // valueTextView.setBackgroundColor(Integer.parseInt(hex, 16));
        });

        return rootView;
    }

    private void setSeekBarColor(SeekBar seekBar, int color) {
        Drawable progressDrawable = seekBar.getProgressDrawable();
        progressDrawable.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN);

        Drawable thumbDrawable = seekBar.getThumb();
        thumbDrawable.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN);
    }
}
