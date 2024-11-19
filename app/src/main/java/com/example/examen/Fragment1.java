package com.example.examen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private TextView valueTextView;
    private SeekBar seekBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment1, container, false);
        seekBar = rootView.findViewById(R.id.seekBar);

        Button size = rootView.findViewById(R.id.button);

        valueTextView = rootView.findViewById(R.id.texto);
        //valueTextView.setTextSize(1);

        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nro = seekBar.getProgress();
                valueTextView.setTextSize(nro);
            }
        });
        return rootView;

    }
}
