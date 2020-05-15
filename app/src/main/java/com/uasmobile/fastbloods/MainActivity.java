package com.uasmobile.fastbloods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextEmail;
    EditText mTextTelpon;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;
    ViewGroup progressView;
    protected boolean isProgressShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        mTextEmail = findViewById(R.id.editEmail);
        mTextPassword = findViewById(R.id.editPassword);
        mButtonLogin = findViewById(R.id.buttonMasuk);
        mTextViewRegister = findViewById(R.id.textDaftar);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mTextEmail.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.CheckUser(email, pwd);

                if(res==true)
                {
                    Toast.makeText(MainActivity.this,"Masuk Berhasil", Toast.LENGTH_SHORT).show();
                    Intent contentIntent = new Intent(MainActivity.this, ActivityContent.class);
                    startActivity(contentIntent);;

                }

                else{
                    Toast.makeText(MainActivity.this,"Username atau Password Anda Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
