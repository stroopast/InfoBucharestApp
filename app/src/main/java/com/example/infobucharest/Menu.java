package com.example.infobucharest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView logout;
        Button monuments;

        logout = findViewById(R.id.logoutTextView);
        monuments = findViewById(R.id.monumentsBtn);

        logout.setOnClickListener(view -> logoutTextView());
        monuments.setOnClickListener(view -> monumentsBtnClick());
    }

    public void logoutTextView(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void monumentsBtnClick(){
        Intent intent = new Intent(this, MonumentsList.class);
        startActivity(intent);
    }
}