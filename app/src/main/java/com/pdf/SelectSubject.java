package com.pdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SelectSubject extends AppCompatActivity {
    RecyclerView subview2;
    myadapter1 adapter;
    private ArrayList<String> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_select_subject);

        subview2 =(RecyclerView)findViewById(R.id.subview2);
        subview2.setLayoutManager(new LinearLayoutManager(this));

        String dept = getIntent().getStringExtra("dept");
        String year = getIntent().getStringExtra("year");

        array = new ArrayList<String>();

        array.add(dept);
        array.add(year);

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child(dept).child(year).child("Subjects"), model.class)
                        .build();

        adapter = new myadapter1(options, getApplicationContext(), array);
        subview2.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}