package com.example.canvas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.graphics.Path;

public class Fragment_2 extends Fragment {
    LinearLayout linearLayout;
    Canvas_2 canvas_2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2, container, false);
        linearLayout = (LinearLayout) v.findViewById(R.id.frag2);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        canvas_2 = new Canvas_2(getContext());
        linearLayout.addView(canvas_2);
    }

    public void getPath(Path path) {
        canvas_2.drawPath(path);
    }
}
