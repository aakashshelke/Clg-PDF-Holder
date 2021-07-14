package com.pdf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    Button register_btn;
    EditText reg_name, reg_email, reg_pass;
    TextView textView;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        reg_name = (EditText)findViewById(R.id.reg_name);
        reg_email = (EditText)findViewById(R.id.reg_email);
        reg_pass = (EditText)findViewById(R.id.reg_pass);
        register_btn = (Button)findViewById(R.id.register_btn);
        textView = (TextView)findViewById(R.id.textView);

        mAuth = FirebaseAuth.getInstance();


        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    /*private void createUser(){
        String email = reg_email.getText().toString();
        String pass = reg_pass.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            reg_email.setError("Email cannot be empty");
            reg_email.requestFocus();
        }else if(TextUtils.isEmpty(pass))
        {
            reg_pass.setError("Password cannot be empty");
            reg_pass.requestFocus();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Registration error: "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }*/

    private void createUser(){
        String email = reg_email.getText().toString();
        String pass = reg_pass.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            reg_email.setError("Email cannot be empty");
            reg_email.requestFocus();
        }
        else if(TextUtils.isEmpty(pass))
        {
            reg_pass.setError("Password cannot be empty");
            reg_pass.requestFocus();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Registration error: "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}