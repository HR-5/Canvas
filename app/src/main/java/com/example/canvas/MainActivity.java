package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity implements Fragment_1.Fragment1Listener {
    Fragment_1 fragment_1;
    Fragment_2 fragment_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment_1 = new Fragment_1();
        fragment_2 = new Fragment_2();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container1, fragment_1)
                .replace(R.id.container2, fragment_2)
                .commit();
    }

    public void input(Path path){
        fragment_2.getPath(path);
    }
}
