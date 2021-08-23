package com.example.infobucharest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView logout;

        logout = findViewById(R.id.logoutTextView);

        logout.setOnClickListener(view -> logoutTextView());
    }

    public void logoutTextView(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}