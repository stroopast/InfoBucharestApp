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

public class MainActivity extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button mLogin, mRegister;
    FirebaseAuth fAuth;
    ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.emailLogin);
        mPassword = findViewById(R.id.passwordLogin);
        mLogin = findViewById(R.id.loginBtn);
        mRegister = findViewById(R.id.registerBtn);
        fAuth = FirebaseAuth.getInstance();
        progressBar2 = findViewById(R.id.progressBar2);

        mLogin.setOnClickListener(view -> {
            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();

            if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                mEmail.setError("Email is Required!");
                mPassword.setError("Password is Required!");
            } else if(TextUtils.isEmpty(email)){
                mEmail.setError("Email is Required!");
            } else if(TextUtils.isEmpty(password)){
                mPassword.setError("Password is Required!");
            } else if(password.length() < 6){
                mPassword.setError("Password must have at least 6 characters");
            }

            progressBar2.setVisibility(View.VISIBLE);

            fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Menu.class));
                } else{
                    Toast.makeText(MainActivity.this, "Error! " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar2.setVisibility(View.INVISIBLE);
                }
            });
        });
    }

    public void registerButton(View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}