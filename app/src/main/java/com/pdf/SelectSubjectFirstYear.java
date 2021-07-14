package com.pdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SelectSubjectFirstYear extends AppCompatActivity {
    RecyclerView subview;
    myadapter1 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_select_subject_first_year);

        subview =(RecyclerView)findViewById(R.id.subview);
        subview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Information Technology").child("1st Year").child("Subjects"), model.class)
                        .build();

        ArrayList<String> array = new ArrayList<String>();

        array.add("Information Technology");
        array.add("1st Year");
        adapter = new myadapter1(options, getApplicationContext(), array);
        subview.setAdapter(adapter);
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