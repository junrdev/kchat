package com.junrdev.kchat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting custom toolbar
//        MaterialToolbar toolbar = findViewById(R.id.chatListToolBar);
//        setSupportActionBar(toolbar);
//

        setContentView(R.layout.activity_main);
    }
}