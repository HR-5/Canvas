package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.graphics.Path;

public class Fragment_1 extends Fragment {
    private Fragment1Listener listener;
    LinearLayout linear;
    Canvas_1 canvas_1;

    public interface Fragment1Listener {
        void input(Path path);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_1, container, false);
        linear = (LinearLayout) v.findViewById(R.id.frag1);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        canvas_1 = new Canvas_1(getContext(),listener);
        linear.addView(canvas_1);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Fragment1Listener) {
            listener = (Fragment1Listener) context;
        }

    }
}
