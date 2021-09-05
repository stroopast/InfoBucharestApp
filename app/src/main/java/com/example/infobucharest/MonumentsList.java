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

        Button backBtn, archOfTriumpf, memorialOfRebirth, carolStatue, kmo;

        backBtn = findViewById(R.id.backBtnMonumentsList);
        archOfTriumpf = findViewById(R.id.archBtn);
        memorialOfRebirth = findViewById(R.id.memorialBtn);
        carolStatue = findViewById(R.id.carolStatueBtn);
        kmo = findViewById(R.id.kmoBtn);

        backBtn.setOnClickListener(View -> backClick());
        archOfTriumpf.setOnClickListener(View -> archOfTriumpfClick());
    }

    public void backClick(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void archOfTriumpfClick(){
        Intent intent = new Intent(this, ArchOfTriumph.class);
        startActivity(intent);
    }

    public void memorialOfRebirthClick(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void carolStatueClick(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void kmoClick(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}