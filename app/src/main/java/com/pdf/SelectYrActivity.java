package com.pdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectYrActivity extends AppCompatActivity {
    ImageView img;
    private TextView txt;
    Button FY_btn, SY_btn, TY_btn, final_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_select_yr);


        img = findViewById(R.id.branch_img);
        txt = findViewById(R.id.branch_name);

        FY_btn = (Button)findViewById(R.id.FY_btn);
        SY_btn = (Button)findViewById(R.id.SY_btn);
        TY_btn = (Button)findViewById(R.id.TY_btn);
        final_btn = (Button)findViewById(R.id.final_btn);

        String dept = getIntent().getStringExtra("dept");
        txt.setText(dept);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            int i = bundle.getInt("image");
            img.setImageResource(i);
        }

        FY_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectYrActivity.this, SelectSubjectFirstYear.class);
                startActivity(intent);
            }
        });

        SY_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectYrActivity.this, SelectSubject.class);
                intent.putExtra("dept", dept);
                intent.putExtra("year", "2nd Year");
                startActivity(intent);
            }
        });

        TY_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectYrActivity.this, SelectSubject.class);
                intent.putExtra("dept", dept);
                intent.putExtra("year", "3rd Year");
                startActivity(intent);
            }
        });

        final_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectYrActivity.this, SelectSubject.class);
                intent.putExtra("dept", dept);
                intent.putExtra("year", "4th Year");
                startActivity(intent);
            }
        });
    }
}