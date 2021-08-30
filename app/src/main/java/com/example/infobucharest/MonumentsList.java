package com.example.infobucharest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MonumentsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monuments_list);

        Button backBtn;

        backBtn = findViewById(R.id.backBtnMonumentsList);

        backBtn.setOnClickListener(View -> backClick());
    }

    public void backClick(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}