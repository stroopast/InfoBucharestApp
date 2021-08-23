package com.example.infobucharest;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    EditText resetEmail;
    Button sendEmailBtn, backbtn;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        resetEmail = findViewById(R.id.resetEmail);
        sendEmailBtn = findViewById(R.id.sendBtn);
        progressBar = findViewById(R.id.progressBar3);
        backbtn = findViewById(R.id.backButton);

        fAuth = FirebaseAuth.getInstance();

        sendEmailBtn.setOnClickListener(view -> resetPassword());

        backbtn.setOnClickListener(view -> resetBtn());

    }

    private void resetPassword(){

        String email = resetEmail.getText().toString().trim();

        if(email.isEmpty()){
            resetEmail.setError("Email is Required!");
            resetEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            resetEmail.setError("Invalid Email Address!");
            resetEmail.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        fAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
           if(task.isSuccessful()){
               Toast.makeText(ResetPassword.this, "An email with instructions has been sent!", Toast.LENGTH_SHORT).show();
           } else{
               Toast.makeText(ResetPassword.this, "Please! Try again!", Toast.LENGTH_SHORT).show();
           }
        });
        resetBtn();
    }

    public void resetBtn(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}