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
    EditText mFirstName, mPhoneNumber, mEmail, mPassword;
    Button mRegisterButton, backButton;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirstName = findViewById(R.id.firstName);
        mPhoneNumber = findViewById(R.id.phoneNumber);
        mEmail = findViewById(R.id.emailAddress);
        mPassword = findViewById(R.id.password);
        mRegisterButton = findViewById(R.id.registerButton);
        progressBar = findViewById(R.id.progressBar);
        backButton = findViewById(R.id.backBtnRegister);

        backButton.setOnClickListener(view -> backBtn());

        fAuth = FirebaseAuth.getInstance();

        mRegisterButton.setOnClickListener(view -> {
            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            String firstName = mFirstName.getText().toString().trim();
            String phonenumber = mPhoneNumber.getText().toString().trim();

            if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && password.length() < 6 && TextUtils.isEmpty(firstName) && TextUtils.isEmpty(phonenumber)){
                mEmail.setError("Email is Required!");
                mPassword.setError("Password is Required!");
                mFirstName.setError("First Name is Required");
                mPhoneNumber.setError("Phone Number is Required");
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
            } else if(TextUtils.isEmpty(phonenumber)){
                mPhoneNumber.setError("Phone Number is Required!");
            }

            AccountsModel accountsModel = new AccountsModel(firstName, Integer.parseInt(phonenumber), email, password);

            progressBar.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "Account Created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(Register.this, "Error! " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            DataBase dataBase = new DataBase(Register.this);

            boolean succes = dataBase.addOne(accountsModel);
            Toast.makeText(Register.this, "Succes= " + succes, Toast.LENGTH_SHORT).show();

        });

    }

    public void backBtn(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}