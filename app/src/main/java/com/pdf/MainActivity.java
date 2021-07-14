package com.pdf;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button btn_CS, btn_IT, btn_ENTC, btn_Mech, btn_Civil;
    ImageView btn_Logout;
    private long backPressedTime;

    @Override
    public void onBackPressed() {
        if(backPressedTime+2000 >System.currentTimeMillis())
        {
            moveTaskToBack(true);
            return;
        }
        else
        {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btn_CS = (Button)findViewById(R.id.btn_CS);
        btn_IT = (Button)findViewById(R.id.btn_IT);
        btn_ENTC = (Button)findViewById(R.id.btn_ENTC);
        btn_Mech = (Button)findViewById(R.id.btn_Mech);
        btn_Civil =(Button)findViewById(R.id.btn_Civil);
        btn_Logout = (ImageView) findViewById(R.id.imageView);
        mAuth = FirebaseAuth.getInstance();

        btn_CS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dept = "Computer Science";
                Intent intent = new Intent(MainActivity.this, SelectYrActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("image", R.drawable.m);
                intent.putExtra("dept", dept);
                startActivity(intent);
            }
        });

        btn_IT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dept = "Information Technology";
                Intent intent = new Intent(MainActivity.this, SelectYrActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("image", R.drawable.it_wall);
                intent.putExtra("dept", dept);
                startActivity(intent);
            }
        });

        btn_ENTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dept = "ENTC";
                Intent intent = new Intent(MainActivity.this, SelectYrActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("image", R.drawable.entc_wall);
                intent.putExtra("dept", dept);
                startActivity(intent);
            }
        });

        btn_Mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dept = "Mechanical";
                Intent intent = new Intent(MainActivity.this, SelectYrActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("image", R.drawable.mech_wall);
                intent.putExtra("dept", dept);
                startActivity(intent);
            }
        });

        btn_Civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dept = "Civil";
                Intent intent = new Intent(MainActivity.this, SelectYrActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("image", R.drawable.civil_wall);
                intent.putExtra("dept", dept);
                startActivity(intent);
            }
        });

        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Toast.makeText(MainActivity.this, "Logged out Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });



    }
}