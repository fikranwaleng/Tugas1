package com.uasmobile.fastbloods;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextEmail;
    EditText mTextTelpon;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.editText7);
        mTextEmail = (EditText)findViewById(R.id.editText8);
        mTextTelpon = (EditText)findViewById(R.id.editText9);
        mTextPassword = (EditText)findViewById(R.id.editText10);
        mTextCnfPassword = (EditText)findViewById(R.id.editText11);
        mButtonRegister = (Button)findViewById(R.id.button2);
        mTextViewLogin = (TextView) findViewById(R.id.textView4);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String email = mTextEmail.getText().toString().trim();
                String telpon = mTextTelpon.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                if (pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,email,telpon,pwd);
                    if (val > 0){
                        Toast.makeText(RegisterActivity.this,"Berhasil Melakukan Pendaftaran", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(moveToLogin);
                    }

                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Kata Sandi dan Konfirmasi Kata Sandi Harus Sama", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
