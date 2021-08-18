package com.example.infobucharest;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Register extends AppCompatActivity {
    EditText mFirstName, mLastName, mEmail, mPassword;
    Button mRegisterButton;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirstName = findViewById(R.id.firstName);
        mLastName = findViewById(R.id.lastName);
        mEmail = findViewById(R.id.emailAddress);
        mPassword = findViewById(R.id.password);
        mRegisterButton = findViewById(R.id.registerButton);
        progressBar = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();

        mRegisterButton.setOnClickListener(view -> {
            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            String firstName = mFirstName.getText().toString().trim();
            String lastName = mLastName.getText().toString().trim();

            if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && password.length() < 6 && TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName)){
                mEmail.setError("Email is Required!");
                mPassword.setError("Password is Required!");
                mPassword.setError("Password must have at least 6 characters");
                mFirstName.setError("First Name is Required");
                mLastName.setError("Last Name is Required");
                return;
            } else if(TextUtils.isEmpty(email)){
                mEmail.setError("Email is Required!");
                return;
            } else if(TextUtils.isEmpty(password)){
                mPassword.setError("Password is Required!");
                return;
            } else if(password.length() < 6){
                mPassword.setError("Password must have at least 6 characters");
                return;
            } else if(TextUtils.isEmpty(firstName)){
                mFirstName.setError("First Name is Required");
                return;
            } else if(TextUtils.isEmpty(lastName)){
                mLastName.setError("Last Name is Required");
            }

            progressBar.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "Account Created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(Register.this, "Error! " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}